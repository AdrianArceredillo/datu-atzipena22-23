package fitxategiak;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import javax.naming.spi.DirectoryManager;

public class Path_Fitxategiak {

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        Path p1 = Paths.get("fileio/karpeta_berriak");
        // Path p1 = Paths.get("mendiencsva/Mendiak.csv");
        Path targetDirectory = Paths.get("./fileio/nuevas_Carpetas/");
        // Files.notExists(p1);

        if (Files.notExists(p1)) {
            // Logic when the paths locate the same file
            System.out.println("No hay nada! ");
        } else {
            if (!Files.exists(targetDirectory)) {
                // fileDestination.mkdir();
                targetDirectory.toFile().mkdir();
            }
        }

        // Reading only files in the directory
        try {
            List<File> files = Files.list(p1)
                    .map(Path::toFile)
                    .filter(File::isFile)
                    // .filter(File::isDirectory)
                    .collect(Collectors.toList());

            files.forEach(System.out::println);

            for (int i = 0; i < files.size(); ++i) {
                inputStream = new BufferedReader(new FileReader(files.get(i).getAbsoluteFile()));
                // outputStream = new PrintWriter(new FileWriter("fileio/nuevas_Carpetas/2.txt"));
                String result = "fileio/nuevas_Carpetas/" + files.get(i).getName();
                outputStream = new PrintWriter(new FileWriter(result));

                String lerroa;
                while ((lerroa = inputStream.readLine()) != null) {
                    outputStream.println(lerroa);
                }
                
            }

            // Files.copy(p1, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }
}

// https://howtodoinjava.com/java8/java-8-list-all-files-example/
// https://www.delftstack.com/es/howto/java/file-path-in-java/
// https://docs.oracle.com/javase/tutorial/essential/io/copy.html
// https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#copy-java.io.InputStream-java.nio.file.Path-java.nio.file.CopyOption...-
// https://docs.oracle.com/javase/tutorial/essential/io/check.html
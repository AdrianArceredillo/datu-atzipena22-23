package fitxategiak;

// import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFiles {
    public static void main(String[] args) throws IOException {

        // File fileSource = new File("./iostreams/src/main/java/fitxategiak/");
        // File fileDestination = new File("./iostreams/src/main/java/twr");

        // String source = "./iostreams/src/main/java/fitxategiak";
        // String destination = "./iostreams/src/main/java/twr";

        Path sourceDirectory = Paths.get("./iostreams/src/main/java/fitxategiak");
        Path targetDirectory = Paths.get("./iostreams/src/main/java/twr");

        if (!Files.exists(targetDirectory)) {
            // fileDestination.mkdir();
            targetDirectory.toFile().mkdir();
            Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
        } else {
            // Files.copy(sourceDirectory, targetDirectory);
        }




        // InputStream is = null;
        // OutputStream os = null;
        // try {
        // is = new FileInputStream(src);
        // os = new FileOutputStream(dest);

        // byte[] buf = new byte[1024];
        // int bytesRead;
        // while ((bytesRead = is.read(buf)) > 0) {
        // os.write(buf, 0, bytesRead);
        // }
        // } finally {
        // is.close();
        // os.close();
        // }

    }
}

// https://www.baeldung.com/java-copy-directory

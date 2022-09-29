package fitxategiak;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Path_Fitxategiak {

    public static void main(String[] args) throws IOException {

        Path p1 = Paths.get("fileio/karpeta_berriak");
        Path targetDirectory = Paths.get("./fileio/nuevas_Carpetas/");
        Scanner in = new Scanner(System.in);
        // String a = "fileio/karpeta_berriak/animaliak";

        // verSoloSubdirectorios("fileio/karpeta_berriak/animaliak"); // solo
        // subdirectorios
        verContenidoCompletoDirectorio("fileio/karpeta_berriak/animaliak"); // todo el contenido

        String carpeta = "";
        String ficheroNuevo = "";
        String contenido = "";

        System.out.println();
        System.out.print("Zer zoaz deskribatzera? "); // concretar la ubicación/path de destino
        carpeta = in.nextLine();

        System.out.println("Zein? "); // asignar un nombre al nuevo fichero que se va a crear
        ficheroNuevo = in.next();

        System.out.println("Nolakoa da? "); // especificar el contenido que tendrá el nuevo archivo
        contenido = in.next();

        System.out.println("====================================");

    }

    public static void verificarCarpetaUsuario(String ubicacionUser) throws IOException {
        String rutaInicial = "fileio/karpeta_berriak";
        String rutaBusqueda = rutaInicial + "/" + ubicacionUser;

        Path p2 = Paths.get(rutaBusqueda);

        verSoloSubdirectorios(rutaBusqueda);

        if (Files.notExists(p2)) {
            System.out.println("No hay nada! ");
            // p1.toFile().mkdir();
        } else {

        }
    }

    public static void verSoloSubdirectorios(String ruta1) throws IOException { // ver solo los SUBDIRECTORIOS que hay
                                                                                // dentro de la
        // carpeta que hemos indicado
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        Path p1 = Paths.get(ruta1);
        // Path targetDirectory = Paths.get("./fileio/nuevas_Carpetas/");

        if (Files.notExists(p1)) {
            System.out.println("No hay nada! ");
        } else {
            // Reading only files in the directory
            try {
                List<File> files = Files.list(p1)
                        .map(Path::toFile)
                        .filter(File::isFile)
                        // .filter(File::isDirectory)
                        .collect(Collectors.toList());

                files.forEach(System.out::println);

                // File file2 = new File("fileio/karpeta_berriak");
                File file = new File(p1.toString());
                String[] directories = file.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File current, String name) {
                        return new File(current, name).isDirectory();
                    }
                });

                for (int i = 0; i < directories.length; ++i) {
                    System.out.println(directories[i].toString());
                }
                // System.out.println(Arrays.toString(directories)); //ver en un Array los
                // nombres de los subdirectorios

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

    public static void verContenidoCompletoDirectorio(String ruta1) throws IOException { // ver TODO el contenido de la
                                                                                         // carpeta
        // (subcarpetas y ficheros)
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        Path p1 = Paths.get(ruta1);

        if (Files.notExists(p1)) {
            System.out.println("No hay nada! ");
        } else {
            // Reading only files in the directory
            try {
                List<File> files = Files.list(p1)
                        .map(Path::toFile)
                        .filter(File::isFile)
                        // .filter(File::isDirectory)
                        .collect(Collectors.toList());

                files.forEach(System.out::println);

                File file = new File(ruta1);
                List<File> models = new ArrayList<>();

                file.list(new FilenameFilter() {

                    @Override
                    public boolean accept(File current, String name) {
                        models.add(new File(current, name));
                        files.add(new File(current, name));
                        boolean imprimir = false;
                        
                        return new File(current, name).isDirectory();
                    }
                });

                for (int i = 0; i < files.size(); ++i) {
                    System.out.println(files.get(i).toString());
                }

            }
            catch (IOException e) {
            e.printStackTrace();
            }
            finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }

    }

    public static void copiarContenidoCarpeta(String rutaOrigen, String rutaDestino) throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        Path p1 = Paths.get(rutaOrigen);
        Path targetDirectory = Paths.get(rutaDestino);

        if (Files.notExists(p1)) {
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
                String result = "fileio/nuevas_Carpetas/" + files.get(i).getName();
                outputStream = new PrintWriter(new FileWriter(result));

                String lerroa;
                while ((lerroa = inputStream.readLine()) != null) {
                    outputStream.println(lerroa);
                }
            }

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
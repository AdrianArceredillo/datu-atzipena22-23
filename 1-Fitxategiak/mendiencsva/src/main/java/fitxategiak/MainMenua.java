package main.java.fitxategiak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MainMenua {

    private static String[] mendiak;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2. Mendirik altuena bistaratu");
            System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Sartu mendi berri bat");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    mendienZerrendaIkusi();
                    break;
                case 2:
                    mendirikAltuena();
                    break;
                case 3:
                    mendiakEsportatu();
                    break;
                case 4:
                    mendiBerria();
                    break;
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    public static void mendienZerrendaIkusi() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));

            String lerroa;
            int lerroZenbakia = 0;

            while ((lerroa = inputStream.readLine()) != null) {
                // outputStream.println(lerroa);
                mendiak = lerroa.split(";");
                if (lerroZenbakia != 0) {
                    System.out.printf(" %s - %s %s %s\n", lerroZenbakia, mendiak[0], mendiak[1], mendiak[2]);
                }
                lerroZenbakia++;
            }
        } catch (FileNotFoundException e1) {
            System.out.println("HOLA");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void mendirikAltuena() throws IOException {
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));

            String lerroa;
            int lerroZenbakia = 0;
            String[] mendirirkAltuena = null;

            while ((lerroa = inputStream.readLine()) != null) {
                // outputStream.println(lerroa);
                mendiak = lerroa.split(";");

                if (lerroZenbakia != 0 && (mendirirkAltuena == null
                        || (Integer.parseInt(mendirirkAltuena[1]) < Integer.parseInt(mendiak[1])))) {
                    mendirirkAltuena = mendiak;
                }
                lerroZenbakia++;

            }
            System.out.println();
            System.out.printf("Mendirik altuena honako hau da: %s %s %s\n", mendirirkAltuena[0], mendirirkAltuena[1],
                    mendirirkAltuena[2]);

        } catch (FileNotFoundException e1) {
            System.out.println("HOLA");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }

    public static void mendiakEsportatu() throws IOException {
        BufferedReader inputStream = null;

        PrintWriter outputStream = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Aukeratu probintzia bat:");
        System.out.println("1.- Araba");
        System.out.println("2.- Gipuzkoa");
        System.out.println("3.- Bizkaia");
        System.out.println("4.- Nafarroa");
        System.out.println("---------------");
        System.out.print("Sartu aukera bat: ");
        int aukera = scanner.nextInt();
        String probintzia = "";
        switch (aukera) {
            case 1:
                outputStream = new PrintWriter(new FileWriter("mendiencsva/MendiakAraba.csv"));
                probintzia = "Araba";
                break;
            case 2:
                outputStream = new PrintWriter(new FileWriter("mendiencsva/MendiakGipuzkoa.csv"));
                probintzia = "Gipuzkoa";
                break;
            case 3:
                outputStream = new PrintWriter(new FileWriter("mendiencsva/MendiakBizkaia.csv"));
                probintzia = "Bizkaia";
                break;
            case 4:
                outputStream = new PrintWriter(new FileWriter("mendiencsva/MendiakNafarroa.csv"));
                probintzia = "Nafarroa";
                break;
            default:
                mendiakEsportatu();
        }

        try {
            inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));

            String lerroa;
            while ((lerroa = inputStream.readLine()) != null) {
                mendiak = lerroa.split(";");

                if (probintzia.equals(mendiak[2])) {
                    outputStream.println(lerroa);
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }


    public static void mendiBerria() throws IOException {
        BufferedReader inputStream = null;

        PrintWriter outputStreamBerria = null;
        PrintWriter outputStream = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("\tIzena: ");
        String izena = scanner.next();
        izena = izena.substring(0, 1).toUpperCase() + izena.substring(1);

        System.out.print("\tAltuera: ");
        int altuera = scanner.nextInt();

        System.out.print("\tProbintzia: ");
        String probintzia = scanner.next();

        if ((!probintzia.equals("Nafarroa")) || (!probintzia.equals("Gipuzkoa"))  || (!probintzia.equals("Araba")) || (!probintzia.equals("Bizkaia"))) {
            outputStreamBerria = new PrintWriter(new FileWriter("mendiencsva/" + probintzia + ".csv"));
        }

        try {
            inputStream = new BufferedReader(new FileReader("mendiencsva/Mendiak.csv"));

            String lerroa;
            String mendiBerria = izena + ";" + String.valueOf(altuera) + ";" + probintzia.toLowerCase();

            while ((lerroa = inputStream.readLine()) != null) {
                mendiak = lerroa.split(";");

                // if (probintzia.equals(mendiak[2])) {
                //     outputStreamBerria.println(lerroa);
                    
                // } 
            }

            outputStreamBerria.println(mendiBerria);
            // outputStream.println(mendiBerria);

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStreamBerria != null) {
                outputStreamBerria.close();
            }
        }

    }
}

// https://stackoverflow.com/questions/41353900/java-how-to-compare-columns-of-a-csv-file-and-print-specific-lines
// https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/

package main.java.fitxategiak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
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
            System.out.println("4.- ...");
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
            String zenbAltuera;
            
            while ((lerroa = inputStream.readLine()) != null) {
                // outputStream.println(lerroa);
                mendiak = lerroa.split(";");
                System.out.printf("%s %s %s\n", mendiak[0], mendiak[1], mendiak[2]);
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
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<String> mendienLista = new ArrayList<>();
        // Input of file which needs to be parsed
        String csvFile = "mendiencsva/Mendiak.csv";
        BufferedReader csvReader;
        
        try {
            String line;
            csvReader = new BufferedReader(new FileReader(csvFile));
            while ((line = csvReader.readLine()) != null) {
                mendienLista.add(line);
            }
            csvReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < mendienLista.size(); i++) {
            // String[] data = mendienLista.get(i).split(";");
            // String col1 = data[0];
            // String col2 = Float.parseFloat(data[1]);
            // String col3 = data[2];

            System.out.println(mendienLista.get(i));
            // resultList.add(mendienLista.get(1));    
        }



    }

}

// https://stackoverflow.com/questions/41353900/java-how-to-compare-columns-of-a-csv-file-and-print-specific-lines
// https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
package fitxategiak;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {
        
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("charOutLinesZenbakiekin.txt"));

            String lerroa;
            int numLineas = 0;
            while ((lerroa = inputStream.readLine()) != null) { 
                numLineas++;
                outputStream.println(numLineas + "- " + lerroa);
            }

            // System.out.println("Hay un total de: " + numLineas + " lineas en el documento.");

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

package dambi.mainklaseak;
//package com.danibuiza.jaxb.ultimate.marshal;

import dambi.pojoak.Mendiak;
import dambi.pojoak.*;
import dambi.atzipenekoak.*;

import java.io.*;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Irakurketa {

    private static String[] mendiak;

    public static void main(String[] args) throws IOException {
        System.out.println("\n"); 
        System.out.println("Irakurri CSVa"); mendiakIrakurri();

    }

    public static void mendiakIrakurri() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("mendienfitxategiak/Mendiak.csv"));

            String lerroa;
            int lerroZenbakia = 0;

            while ((lerroa = inputStream.readLine()) != null) {
                // outputStream.println(lerroa);
                mendiak = lerroa.split(";");
                if (lerroZenbakia != 0) {
                    System.out.printf("%s %s %s\n", mendiak[0], mendiak[1], mendiak[2]);

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



    
}
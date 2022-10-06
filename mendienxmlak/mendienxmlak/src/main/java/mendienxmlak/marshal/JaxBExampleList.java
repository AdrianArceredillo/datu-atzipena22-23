package mendienxmlak.marshal;
//package com.danibuiza.jaxb.ultimate.marshal;

// import mendienxmlak.business.*;
import mendienxmlak.business.Mendiak;
import mendienxmlak.business.Mendia;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * Simple example of usage of jaxb marshaling functionalities showing how to
 * manage lists
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleList {

    public static void main(String[] args) {
        try {

            /* init a list with a couple of countries to marshal */

            /*
             * Aketegi;1548;Gipuzkoa
             * Albertia;868;Araba
             * Alluitz;1034;Bizkaia
             */
            Mendia aketegi = new Mendia();
            aketegi.setIzena("Aketegi");
            aketegi.setAltuera(1548);
            aketegi.setProbintzia("Gipuzkoa");
            aketegi.setImportance(1);

            Mendia albertia = new Mendia();
            albertia.setIzena("Albertia");
            albertia.setAltuera(868);
            albertia.setProbintzia("Araba");
            albertia.setImportance(4);

            Mendia alluitz = new Mendia();
            alluitz.setIzena("Alluitz");
            alluitz.setAltuera(1034);
            alluitz.setProbintzia("Bizkaia");
            alluitz.setImportance(3);

            Mendiak mendiakLista = new Mendiak();
            mendiakLista.add(aketegi);
            mendiakLista.add(albertia);
            mendiakLista.add(alluitz);

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(mendiakLista, new File("hirumendi.xml"));
            jaxbMarshaller.marshal(mendiakLista, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

package dambi.mainklaseak;

import dambi.pojoak.*;
import dambi.atzipenekoak.*;

import java.io.*;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/*
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
 */

public class CsvtikJsonera {

    private static Mendiak mendiGuztiak = new Mendiak();
    //private static String[] mendiak;

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\n");
        System.out.println("Csv-tik Xml-ra");

        Csva csva = new Csva("mendienfitxategiak/mendienfitxategiak/Mendiak.csv",
                "mendienfitxategiak/src/main/java/dambi/atzipenekoak/Mendiak.json");

        
        Mendiak montes = new Mendiak();

        System.out.println(csva.irakurri().getMendiak());
        //montes.setMendiak(csva.irakurri().getMendiak());

        int cant = csva.idatzi(montes);
        System.out.println(cant);

        // irakurritakoMendiak = csva.irakurri();

    }
}

package dambi.mainklaseak;

import dambi.pojoak.*;
import dambi.atzipenekoak.*;

import java.io.*;
import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class CsvtikXmlra {

    private static Mendiak mendiGuztiak = new Mendiak();
    private static String[] mendiak;

    public static void main(String[] args) throws IOException {

        System.out.println("\n");
        System.out.println("Csv-tik Xml-ra");

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        Csva csva = new Csva("mendienfitxategiak/Mendiak.csv", "mendienfitxategiak/Mendiak.xml");

        try {
            inputStream = new BufferedReader(new FileReader("mendienfitxategiak/Mendiak.csv"));

            String lerroa;
            int lerroZenbakia = 0;

            while ((lerroa = inputStream.readLine()) != null) {
                // outputStream.println(lerroa);
                mendiak = lerroa.split(";");
                if (lerroZenbakia != 0) {
                    System.out.printf("%s %s %s %s\n", lerroZenbakia, mendiak[0], mendiak[1], mendiak[2]);

                    Mendia mendiBakoitza = new Mendia();
                    mendiBakoitza.setId(lerroZenbakia);
                    mendiBakoitza.setMendia(mendiak[0].toString());
                    mendiBakoitza.setAltuera(Integer.parseInt(mendiak[1]));
                    mendiBakoitza.setProbintzia(mendiak[2]);

                    mendiGuztiak.add(mendiBakoitza);

                }
                lerroZenbakia++;
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(mendiGuztiak, new File("Mendiak.xml"));
            jaxbMarshaller.marshal(mendiGuztiak, System.out);


        } catch (FileNotFoundException e1) {
            System.out.println("HOLA");

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}

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

        Csva csva = new Csva("mendienfitxategiak/Mendiak.csv", "atzipenekoak/Mendiak.xml");

        try {
            //inputStream = new BufferedReader(new FileReader("mendienfitxategiak/Mendiak.csv"));
            inputStream = new BufferedReader(new FileReader(csva.getStrFileIn().toString()));

            String lerroa;
            int lerroZenbakia = 0;

            while ((lerroa = inputStream.readLine()) != null) {
                // outputStream.println(lerroa);
                mendiak = lerroa.split(";");
                if (lerroZenbakia != 0) {
                    System.out.printf("%s %s %s %s\n", lerroZenbakia, mendiak[0], mendiak[1], mendiak[2]);

                    //crear un objeto (Mendia) de cada línea leída del fichero CSV
                    Mendia mendiBakoitza = new Mendia();
                    mendiBakoitza.setNum(lerroZenbakia + 100);              //atributo ("Num.") de cada objecto (Mendia)
                    mendiBakoitza.setId(lerroZenbakia);                     //elemento "ID" del objeto
                    mendiBakoitza.setMendia(mendiak[0].toString());         //elemento "Mendia" del objeto
                    mendiBakoitza.setAltuera(Integer.parseInt(mendiak[1])); //elemento "Altuera" del objeto
                    mendiBakoitza.setProbintzia(mendiak[2]);                //elemento "Probintzia" del objeto

                    mendiGuztiak.add(mendiBakoitza);    //guardar cada elemento en la lista "mendiGuztiak" (de tipo Mendiak -> lista de Mendia)

                }
                lerroZenbakia++;
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //
            jaxbMarshaller.marshal(mendiGuztiak, new File("mendienfitxategiak/src/main/java/dambi/atzipenekoak/Mendiak.xml"));
            //C:\Users\AdriAlex\Desktop\DAM_UNI\DAM_2\DAM_2\Acceso_Datos\datu-atzipena22-23\mendienfitxategiak\mendienfitxategiak\src\main\java\dambi\atzipenekoak
            //jaxbMarshaller.marshal(mendiGuztiak, new File("Mendiak.xml"));
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

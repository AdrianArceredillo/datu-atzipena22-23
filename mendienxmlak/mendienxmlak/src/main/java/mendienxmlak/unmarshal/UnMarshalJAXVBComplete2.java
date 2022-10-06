package mendienxmlak.unmarshal;
// package com.danibuiza.jaxb.ultimate.unmarshal;

import mendienxmlak.business.Mendia;
// import mendienxmlak.business.*;
import mendienxmlak.business.Mendiak;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import jakarta.xml.bind.Marshaller;

/**
 * This class shows how to unmarshall a simple XML structure into java classes
 * 
 * @author dgutierrez-diez
 */
public class UnMarshalJAXVBComplete2
{
    public static void main( String[] args )
    {

        try
        {

            File file = new File( "hirumendi.xml" );
            // File file = new File( "countries.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );

            /**
             * the only difference with the marshaling operation is here
             */

            List<File> filesLeer = new ArrayList<>();
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak countres = (Mendiak)jaxbUnmarshaller.unmarshal( file );
            System.out.println( countres );
            // List<Mendia> mend = (List<Mendia>) jaxbUnmarshaller.unmarshal( file );



            //do the MARSHAL again
            JAXBContext jaxbContext_2 = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext_2.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);



            int altuera_Feet = (int) 3.28084;
            for (int i = 0; i < countres.getMendiak().size(); ++i) {

                int altuera_Aldatuta = altuera_Feet * countres.getMendiak().get(i).getAltuera();
                countres.getMendiak().get(i).setAltuera(altuera_Aldatuta);
                /* marshaling of java objects in xml (output to file and standard output) */
                jaxbMarshaller.marshal(countres, new File("mendiakaltueraoinatan.xml"));    //crear nuevo .xml con las neuvas alturas de todos los montes de la lista

                if (countres.getMendiak().get(i).getProbintzia().equals("Gipuzkoa")) {
                    jaxbMarshaller.marshal(countres.getMendiak().get(i), new File("gipuzkoakomendiak.xml"));      //crear nuevo .xml solamente con los montes cuya provincia se "Gipuzkoa"
                } 
                

                // countres.getMendiak().get(i).setAltuera(20);
            }

            jaxbMarshaller.marshal(countres, System.out);

            /* marshaling of java objects in xml (output to file and standard output) */
            // jaxbMarshaller.marshal(countres, new File("lectura.xml"));
            // jaxbMarshaller.marshal(countres, System.out);

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }

    private static File File(String string) {
        return null;
    }

}

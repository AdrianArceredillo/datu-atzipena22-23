package mendienxmlak.unmarshal;
// package com.danibuiza.jaxb.ultimate.unmarshal;

// import mendienxmlak.business.*;
import mendienxmlak.business.Mendiak;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


/**
 * This class shows how to unmarshall a simple XML structure into java classes
 * 
 * @author dgutierrez-diez
 */
public class UnMarshalJAXVBCompleteExample
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
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak countres = (Mendiak)jaxbUnmarshaller.unmarshal( file );
            System.out.println( countres );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }

}

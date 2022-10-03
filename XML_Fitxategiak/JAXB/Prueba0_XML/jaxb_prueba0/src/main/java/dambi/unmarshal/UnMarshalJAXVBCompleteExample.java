package dambi.unmarshal;
// package com.danibuiza.jaxb.ultimate.unmarshal;

import dambi.business.*;
import dambi.business.Countries;

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

            File file = new File( "countries.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Countries.class );

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Countries countres = (Countries)jaxbUnmarshaller.unmarshal( file );
            System.out.println( countres );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }

}

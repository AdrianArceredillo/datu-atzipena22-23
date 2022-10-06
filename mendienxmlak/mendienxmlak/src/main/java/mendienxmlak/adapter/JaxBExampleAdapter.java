package mendienxmlak.adapter;
// package com.danibuiza.jaxb.ultimate.adapter;

// import mendienxmlak.business.*;
import mendienxmlak.business.Mendia;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * Simple example of usage of jaxb marshaling functionalities when managing complex classes, in this
 * case java.time.LocalDate
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleAdapter
{

    public static void main( String[] args )
    {
        try
        {

            /* init very simple data to marshal */
            Mendia monte = new Mendia();
            monte.setIzena( "Prueba" );
            monte.setAltuera( 500 );
            monte.setProbintzia( "Gipuzkoa" );
            monte.setImportance(0);

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendia.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( monte, new File( "mendia_adapter.xml" ) );
            jaxbMarshaller.marshal( monte, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}

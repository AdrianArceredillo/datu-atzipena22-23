package mendienxmlak.business;
// package com.danibuiza.jaxb.ultimate.business;

// import mendienxmlak.adapter.*;
// import mendienxmlak.adapter.DateAdapter;

// import java.time.LocalDate;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
// import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Country containing a name, a capital city, a foundation date and the continent it belongs to,
 * these attributes are going to be represented in this order in the generated XML as described in
 * the annotation XmlType
 * 
 * @author dgutierrez-diez
 */
@XmlType( propOrder = { "izena", "altuera", "probintzia" } )
@XmlRootElement( name = "Mendia" )
public class Mendia
{
    String    izena;

    int    altuera;

    String probintzia;

    int     importance;

    public String getIzena()
    {
        return izena;
    }

    @XmlElement( name = "Mendia_Izena" )
    public void setIzena( String izena )
    {
        this.izena = izena;
    }

    public int getAltuera()
    {
        return altuera;
    }

    @XmlElement( name = "Mendia_Altuera" )
    public void setAltuera( int altuera )
    {
        this.altuera = altuera;
    }

    public String getProbintzia()
    {
        return probintzia;
    }

    @XmlElement( name = "Mendia_Probintzia" )
    public void setProbintzia( String probintzia )
    {
        this.probintzia = probintzia;
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer("Importance: " + getImportance() + "\n" +
         "Izena: " + getIzena() + "\n" );
        str.append( "Altuera: " + getAltuera() + "\n" );

        if( getIzena() != null )
        {
            str.append("Izena: " + getIzena().toString() );
            str.append( "\n" );
        }

        if( getAltuera() != -1 )
        {
            str.append( "Altuera: " + String.valueOf(getAltuera()));
            str.append( "\n" );
        }

        if( getProbintzia() != null )
        {
            str.append( "Probintzia: " + getProbintzia() );
            str.append( "\n" );
        }
        str.append("\n");
        return str.toString();
    }

    

    

    @XmlAttribute( name = "Importance", required = true )
    public void setImportance( int importance )
    {
        this.importance = importance;
    }

    public int getImportance()
    {
        return importance;
    }

}

package dambi.business;
// package com.danibuiza.jaxb.ultimate.business;

import dambi.adapter.*;
import dambi.adapter.DateAdapter;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Country containing a name, a capital city, a foundation date and the continent it belongs to,
 * these attributes are going to be represented in this order in the generated XML as described in
 * the annotation XmlType
 * 
 * @author dgutierrez-diez
 */
@XmlType( propOrder = { "name", "capital", "foundation", "continent", "population", "creator", "importance" } )
@XmlRootElement( name = "Country" )
public class Country
{
    String    name;

    String    capital;

    LocalDate foundation;

    String    continent;

    int       population;

    String      creator;

    int     importance;

    public int getPopulation()
    {
        return population;
    }

    @XmlElement( name = "Country_Population" )
    public void setPopulation( int population )
    {
        this.population = population;
    }

    public String getName()
    {
        return name;
    }

    @XmlElement( name = "Country_Name" )
    public void setName( String name )
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer("Importance: " + getImportance() + "\n" +
         "Name: " + getName() + "\n" );
        str.append( "Capital: " + getCapital() + "\n" );

        if( getFoundation() != null )
        {
            str.append("Foundation Date: " + getFoundation().toString() );
            str.append( "\n" );
        }

        if( getContinent() != null )
        {
            str.append( getContinent().toString() );
            str.append( "\n" );
        }

        if( getPopulation() != 0 )
        {
            str.append( "Population: " + getPopulation() );
            str.append( "\n" );
        }
        str.append("\n");
        return str.toString();
    }

    public String getCapital()
    {
        return capital;
    }

    @XmlElement( name = "Country_Capital" )
    public void setCapital( String capital )
    {
        this.capital = capital;
    }

    public LocalDate getFoundation()
    {
        return foundation;
    }

    @XmlElement( name = "Country_Foundation_Date" )
    @XmlJavaTypeAdapter( DateAdapter.class )
    public void setFoundation( LocalDate foundation )
    {
        this.foundation = foundation;
    }

    public String getContinent()
    {
        return continent;
    }

    @XmlElement( name = "Country_Continent" )
    public void setContinent( String continent )
    {
        this.continent = continent;
    }

    public String getCreator()
    {
        return creator;
    }

    @XmlElement( name = "Country_Creator" )
    public void setCreator( String creator )
    {
        this.creator = creator;
    }

    @XmlAttribute( name = "importance", required = true )
    public void setImportance( int importance )
    {
        this.importance = importance;
    }

    public int getImportance()
    {
        return importance;
    }

}

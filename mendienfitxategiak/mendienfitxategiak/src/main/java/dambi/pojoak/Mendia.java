package dambi.pojoak;

//mirar el archivo copyLines y similares

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "mendia", "altuera", "probintzia" })
@XmlRootElement(name = "Mendia")

public class Mendia {

    int id = 0;
    String mendia;
    int altuera;
    String probintzia;

    int num;




    @XmlAttribute( name = "Num. ", required = true )
    public void setNum( int num )
    {
        this.num = num;
    }
    public int getNum()
    {
        return num;
    }


    @XmlElement(name = "Mendia_Id")
    public void setId( int id )
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }

    // public int getId() {
    //     return id;
    // }
    // @XmlElement(name = "Mendia_Id")
    // public void setId(int id) 
    // {
    //     this.id = id;
    // }

    public String getMendia() {
        return mendia;
    }
    @XmlElement(name = "Mendia_Mendia")
    public void setMendia(String mendia) 
    {
        this.mendia = mendia;
    }

    public int getAltuera() {
        return altuera;
    }
    @XmlElement(name = "Mendia_Altuera")
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    public String getProbintzia() {
        return probintzia;
    }

    @XmlElement(name = "Mendia_Probintzia")
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("Id: " + getId() + "\n" +
                "Mendia: " + getMendia() + "\n");
        str.append("Altuera: " + getAltuera() + "\n");
        str.append("Probintzia: " + getProbintzia() + "\n");

        if (getMendia() != null) {
            str.append("Mendia: " + getMendia().toString());
            str.append("\n");
        }

        if (getAltuera() != -1) {
            str.append("Altuera: " + String.valueOf(getAltuera()));
            str.append("\n");
        }

        if (getProbintzia() != null) {
            str.append("Probintzia: " + getProbintzia());
            str.append("\n");
        }
        str.append("\n");
        return str.toString();
    }

    // @XmlAttribute(name = "Importance", required = true)
    // public void setImportance(int importance) {
    //     this.importance = importance;
    // }

    // public int getImportance() {
    //     return importance;
    // }

}

package dambi.batezbestekoak;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "ikaslea", "batezbestekoa"})
@XmlRootElement(name = "Ikaslea")

public class Ikaslea {
    
    String ikaslea;
    int batezbestekoa;

    public String getIkaslea() {
        return ikaslea;
    }

    @XmlElement(name = "ikaslea")
    public void setIkaslea(String ikaslea) {
        this.ikaslea = ikaslea;
    }

    public int getBatezbestekoa() {
        return batezbestekoa;
    }

    @XmlElement(name = "batezbestekoa")
    public void setBatezbestekoa(int batezbestekoa) {
        this.batezbestekoa = batezbestekoa;
    }

    @Override
    public String toString() {
        return "Batezbestekoa[" + ikaslea + ", "  + batezbestekoa + "]";
    }

}





package dambi.batezbestekoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Ikasleak")

public class Ikasleak {
    List<Ikaslea> ikasleak;

    public List<Ikaslea> getIkasleak() {
        return ikasleak;
    }

    @XmlElement(name = "Ikaslea")
    public void setIkasleak(List<Ikaslea> ikaslead) {
        this.ikasleak = ikasleak;
    }

    public void add(Ikaslea ikaslea) {
        if (this.ikasleak == null) {
            this.ikasleak = new ArrayList<Ikaslea>();
        }
        this.ikasleak.add(ikaslea);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Ikaslea n : this.ikasleak) {
            str.append(n.toString());
            str.append("\n");
        }
        return str.toString();
    }
}

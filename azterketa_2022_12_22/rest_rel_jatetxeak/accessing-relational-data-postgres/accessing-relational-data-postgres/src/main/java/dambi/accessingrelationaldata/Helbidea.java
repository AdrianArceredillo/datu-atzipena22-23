package dambi.accessingrelationaldata;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Helbidea")


public class Helbidea {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="helbidea")
    private String helbidea;
    @Column(name="ordutegia")
    private String ordutegia;
    @Column(name="prezioa")
    private double prezioa;
    @ManyToOne()//(fetch = FetchType.LAZY, optional = false)
    
    private Jatetxea jatetxea;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHelbidea() {
        return helbidea;
    }
    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }
    public String getOrdutegia() {
        return ordutegia;
    }
    public void setOrdutegia(String ordutegia) {
        this.ordutegia = ordutegia;
    }
    public Jatetxea getJatetxea() {
        return jatetxea;
    }
    public void setJatetxea(Jatetxea jatetxea) {
        this.jatetxea = jatetxea;
    }

    
}

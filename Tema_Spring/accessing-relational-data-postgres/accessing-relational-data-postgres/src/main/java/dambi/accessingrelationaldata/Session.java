package dambi.accessingrelationaldata;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Saioa")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="eguna")
    private Date date;
    @Column(name="iraupena")
    private int duration;
    @ManyToOne()
    @JoinColumn(name="user")
    private User user;



}

 

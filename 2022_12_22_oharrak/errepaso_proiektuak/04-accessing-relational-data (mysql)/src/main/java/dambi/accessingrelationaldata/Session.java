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
@Table(name="Saioa")
public class Session {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="eguna")
    private Date date;
    @Column(name="iraupena")
    private int duration;
    @ManyToOne()//(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user")
    private User user;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    
}

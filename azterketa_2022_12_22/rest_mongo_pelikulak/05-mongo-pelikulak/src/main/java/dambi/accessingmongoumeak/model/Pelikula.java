package dambi.accessingmongoumeak.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Pelikula {
	
	private ObjectId id; //Berdin ei da id zein _id jarri  (Eta eremu hau ez erabiltzea be aukera bat da)
	private String title;
	private int year;
	private Director director;
	private List<String> cast;

	
	
	public ObjectId getId() {
		return id; 
		
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		return "Pelikula [title=" + title + ", year=" + year + ", director=" + director + "]";
	}
	
	
}

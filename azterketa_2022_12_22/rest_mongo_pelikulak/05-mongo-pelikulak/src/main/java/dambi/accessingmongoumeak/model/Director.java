package dambi.accessingmongoumeak.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Director {

    private String name;
    private int born;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }

}

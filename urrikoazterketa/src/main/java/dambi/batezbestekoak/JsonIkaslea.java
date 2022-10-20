package dambi.batezbestekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.batezbestekoak.Ikaslea;
import dambi.batezbestekoak.Ikasleak;

public class JsonIkaslea {
    public String strFileIn;
    public String strFileOut;

    public JsonIkaslea(String strFile) {
        strFileIn = strFile;
    }

    public JsonIkaslea(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }
 
    public Ikasleak irakurri() {
        //Notak notak = null;
        //return notak;

        Ikasleak ikasleak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            ikasleak = new Ikasleak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Ikaslea ikaslea = new Ikaslea();

                ikaslea.setIkaslea(jsonobj.getString("ikaslea"));
                ikaslea.setBatezbestekoa(jsonobj.getInt("batezbestekoa"));
                ikasleak.add(ikaslea);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return ikasleak;

    }

    public int idatzi(Ikasleak ikasleak) {
        int ikasleKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Ikaslea n : ikasleak.getIkasleak()) {
            jab.add(Json.createObjectBuilder()
                    .add("ikaslea", n.getIkaslea())
                    .add("batezbestekoa", n.getBatezbestekoa())
                    .build());
                    ikasleKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return ikasleKopurua;

    }
}

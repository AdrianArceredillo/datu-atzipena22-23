package dambi.atzipenekoak;

import java.io.BufferedReader;
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

import dambi.pojoak.*;

public class Csva {
    String strFileIn;
    String strFileOut;

    public String getStrFileIn() {
        return strFileIn;
    }

    public void setStrFileIn(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    public String getStrFileOut() {
        return strFileOut;
    }

    public void setStrFileOut(String strFileOut) {
        this.strFileOut = strFileOut;
    }

    // CONSTRUCTORES
    public Csva(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    public Csva(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    // MÉTODOS
    public Mendiak irakurri() {
        Mendiak irakurritakoMendiak = null;

        try {
            JsonReader lector = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = lector.read();
            JsonArray jsonArray = jsonst.asJsonArray();
            irakurritakoMendiak = new Mendiak();
            for (int i = 0; i < jsonArray.size(); ++i) {

                if (i != 0) {
                    JsonObject jsonobj = jsonArray.getJsonObject(i);
                    Mendia mendia = new Mendia();
                    // irakurritakoMendiak = new Mendiak(); //añadido por mi
                    mendia.setNum(i);
                    mendia.setId(jsonobj.getInt("id"));
                    mendia.setMendia(jsonobj.getString("mendia"));
                    mendia.setAltuera(jsonobj.getInt("altuera"));
                    mendia.setProbintzia(jsonobj.getString("probintzia"));
                    irakurritakoMendiak.add(mendia);
                }

            }
        } catch (Exception e) {
            System.out.println("Arazoak '" + strFileIn + "' fitxategia irakurtzerakoan. ");
        }
        return irakurritakoMendiak;
    }

    public int idatzi(Mendiak mendiak) {
        int mendiKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Mendia m : mendiak.getMendiak()) {
            jab.add(Json.createObjectBuilder()
                    .add(strFileIn, m.getId())
                    .add(strFileIn, m.getMendia())
                    .add(strFileIn, m.getAltuera())
                    .add(strFileIn, m.getProbintzia())
                    .build());

            mendiKopurua++;
        }

        model = jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);

        } catch (FileNotFoundException fnfe) {
            System.out.println("Arazoak fitxategia sortzerakoan. ");
        }

        return mendiKopurua;
    }

}

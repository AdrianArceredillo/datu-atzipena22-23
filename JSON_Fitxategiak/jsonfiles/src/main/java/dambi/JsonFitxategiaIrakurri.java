package dambi;

import java.io.FileReader;
import java.io.FileNotFoundException;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

public class JsonFitxategiaIrakurri {
    public static void main(String[] args) throws FileNotFoundException {

        JsonReader reader = Json.createReader(new FileReader("data/test.json"));
        JsonStructure jsonst = reader.read();
        System.out.println(jsonst);
        
    }
}

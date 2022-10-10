package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

public class CreateJSON {
    public static void main(String[] args) throws FileNotFoundException {
        JsonObject model = Json.createObjectBuilder()
                .add("firstName", "Duke")
                .add("lastName", "Java")
                .add("age", 18)
                .add("streetAddress", "100 Internet Dr")
                .add("city", "JavaTown")
                .add("state", "JA")
                .add("postalCode", "12345")
                .add("phoneNumbers", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "mobile")
                                .add("number", "111-111-1111"))
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "222-222-2222")))
                .build();

        System.out.println(model);

        JsonWriter pruebaSalida = Json.createWriter(new FileOutputStream("data/salidaAdibidea.json"));
        pruebaSalida.writeObject(model);
        pruebaSalida.close();
    }
}

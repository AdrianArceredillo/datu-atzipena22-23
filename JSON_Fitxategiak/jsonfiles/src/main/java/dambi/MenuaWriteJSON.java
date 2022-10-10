package dambi;

import java.io.FileReader;
import java.io.StringWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

public class MenuaWriteJSON {
        public static void main(String[] args) throws FileNotFoundException {

                JsonObject model = Json.createObjectBuilder()
                                .add("popout", Json.createObjectBuilder()
                                                .add("Id", "Duke")
                                                .add("value", "Java")
                                                .add("popout", Json.createObjectBuilder()
                                                                .add("menuitem", Json.createArrayBuilder()
                                                                                .add(Json.createObjectBuilder()
                                                                                                .add("type", "New")
                                                                                                .add("string", "CreateNewDoc()"))
                                                                                .add(Json.createObjectBuilder()
                                                                                                .add("type", "New")
                                                                                                .add("string", "CreateNewDoc()"))
                                                                                .add(Json.createObjectBuilder()
                                                                                                .add("type", "Close")
                                                                                                .add("onclick", "CloseDoc()")))))
                                .build();

                System.out.println(model);

                try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("..data/Menua2.json"))) {
                        jsonWriter.writeObject(model);
                        jsonWriter.close();
                }

                // StringWriter stWriter = new StringWriter();
                // JsonWriter jsonWriter = Json.createWriter(stWriter);
                // jsonWriter.writeObject(model);

                // jsonWriter.close();
                // String jsonData = stWriter.toString();
                // System.out.println(jsonData);

        }
}

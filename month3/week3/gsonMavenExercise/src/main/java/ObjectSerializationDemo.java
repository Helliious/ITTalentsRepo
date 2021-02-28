import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ObjectSerializationDemo {
    public static void main(String[] args) {
        Cup cup = new Cup("Blue", 400);
        Gson gson = new Gson();
        String json = gson.toJson(cup);

        File f = new File("cup.json");
        try (FileWriter fileWriter = new FileWriter(f)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

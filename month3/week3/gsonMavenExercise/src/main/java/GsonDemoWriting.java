import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class GsonDemoWriting {
    public static void main(String[] args) {
        TreeMap<String, Integer> data = new TreeMap<>();
        data.put("Tom", 200);
        data.put("Nick", 300);
        data.put("John", 400);

        JsonObject object = new JsonObject();
        for (Map.Entry<String, Integer> e : data.entrySet()) {
            object.addProperty(e.getKey(), e.getValue());
        }

        Gson gson = new Gson();
        String text = gson.toJson(object);

        File f = new File("gsonData.json");
        try (FileWriter fileWriter = new FileWriter(f)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

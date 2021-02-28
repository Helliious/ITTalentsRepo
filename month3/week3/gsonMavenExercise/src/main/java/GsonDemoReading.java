import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GsonDemoReading {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        File f = new File("data.json");
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                text.append(sc.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(text.toString());

        JsonElement root = JsonParser.parseString(text.toString());
        JsonObject rootObject = root.getAsJsonObject();
        for (int i = 0; i < rootObject.get("data").getAsJsonArray().size(); i++) {
            JsonObject data = rootObject.get("data").getAsJsonArray().get(i).getAsJsonObject();
            System.out.println(data.get("person").toString());
        }
    }
}

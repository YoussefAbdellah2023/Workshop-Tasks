package Files;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class FluentFilesBot {


    //     TODO: WorkShop Tasks (#12) Read browser type from Properties file
    public static String CONFIG_PATH = "src/main/resources/PropertiesFiles/";

    public static String getConfigValue(String fileName, String key) {
        try {
            Properties properties = new Properties();

            try (InputStreamReader reader = new InputStreamReader(
                    Files.newInputStream(Paths.get(CONFIG_PATH + fileName + ".properties")), StandardCharsets.UTF_8)) {
                properties.load(reader);

            }

            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //     TODO: WorkShop Tasks (#11) Read The Text Value from Json File
    public static String CONFIG_JSON_PATH = "src/test/resources/";

    public static Object getJsonData(String fileName, String jsonPath) {
        String filePath = CONFIG_JSON_PATH + fileName + ".json";

        try {

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));
            String jsonReader = jsonObject.toJSONString();


            Object result = JsonPath.read(jsonReader, jsonPath);


            if (result instanceof List) {
                return result;
            }


            return result.toString();

        } catch (Exception e) {
            System.err.println("Error reading JSON file '" + fileName + "' or processing JSONPath '" + jsonPath + "': " + e.getMessage());
        }

        return null;
    }





}
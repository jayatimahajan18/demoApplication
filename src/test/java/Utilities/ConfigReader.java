package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties= new Properties();
     static  {
        try {
            String configPath = System.getProperty("user.dir")+"/src/test/resources/Config/config.properties";
            FileInputStream input = new FileInputStream(configPath);
            properties.load(input);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static String getValue(String key){
        String value = "";
        value = properties.getProperty(key);
        if(Objects.isNull(value)) {
            throw new NullPointerException("Property name " + key + " is not found.");
        }
        return value;
    }
}

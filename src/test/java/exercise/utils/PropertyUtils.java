package exercise.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    public static Properties PropertiesLoader(String fileName){
        Properties properties=new Properties();
        try(InputStream is=PropertyUtils.class.getClassLoader().getResourceAsStream(fileName)) {
            if(is==null){
                throw new RuntimeException("File not found"+fileName);

            }
            properties.load(is);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file "+fileName,e);
        }

        return properties;
    }
}

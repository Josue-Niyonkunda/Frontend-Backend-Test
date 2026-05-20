package exercise.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;
    private ConfigLoader() {
       try {
           properties=PropertyUtils.PropertiesLoader("config.properties");

       }
       catch (Exception e){
           throw new RuntimeException("Failed to load config.properties file",e);
       }
    }

   public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
   }
   private String get(String key){
        String value=properties.getProperty(key);
        if (value==null){
            throw new RuntimeException("Property "+key+"is not specified in config.properties file");
        }
     return value;
   }
   public String getBaseUrl(){
        return get("baseUrl");
   }



}

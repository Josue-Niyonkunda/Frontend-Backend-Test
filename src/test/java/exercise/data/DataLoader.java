package exercise.data;







import exercise.utils.PropertyUtils;

import java.util.Properties;

public class DataLoader {
    private static Properties properties = new Properties();
    private static DataLoader dataLoader;
    private DataLoader(){
        try {
            properties= PropertyUtils.PropertiesLoader("data.properties");

        }
        catch (Exception e){
            throw new RuntimeException("Failed to load data.properties file",e);
        }
    }

    public static DataLoader getInstance(){
        if(dataLoader ==null){
            dataLoader =new DataLoader();
        }
        return dataLoader;
    }
    private static String get(String key){
        String value=properties.getProperty(key);
        if (value==null){
            throw new RuntimeException("Property "+key+"is not specified in data.properties file");
        }
        return value;
    }

    public String email(){
        return get("email");
    }
    public String password(){
        return get("password");
    }
    public String searchProduct(){
        return get("searchProduct");
    }



}

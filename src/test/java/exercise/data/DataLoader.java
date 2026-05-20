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
    public String getUserName(){
        return get("username");
    }
    public String getPassword(){
        return get("password");
    }
    public String wrongPassword(){
        return get("wrongPassword");
    }
    public String wrongUsername(){
        return get("wrongUsername");
    }
    public  String getFirstName(){
        return get("firstName");
    }
    public  String getLastName(){
        return  get("lastName");
    }
    public   String getZipCode(){
        return get("zipCode");
    }
    public String getEmptyData(){
        return get("emptyData");
    }

}

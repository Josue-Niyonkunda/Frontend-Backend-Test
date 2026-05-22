package exercise.data;

import exercise.utils.PropertyUtils;

import java.util.Properties;

public class MessageLoader {
    private static Properties properties=new Properties();
    private static MessageLoader messageLoader;
    private MessageLoader(){
        try {
            properties= PropertyUtils.PropertiesLoader("message.properties");

        }
        catch (Exception e){
            throw new RuntimeException("Failed to load message.properties file",e);
        }
    }

    public static MessageLoader getInstance(){
        if(messageLoader ==null){
            messageLoader =new MessageLoader();
        }
        return messageLoader;
    }
    private static String get(String key){
        String value=properties.getProperty(key);
        if (value==null){
            throw new RuntimeException("Property "+key+" is not specified in message.properties file");
        }
        return value;
    }
    public String productsAddedToTheCart(){
        return get("productsAddedToTheCart");
    }
    public String emailAlreadyCreated(){
        return get("emailAlreadyCreated");
    }
    public String accountCreatedSuccessful() {
        return get("accountCreatedSuccessful");
    }
    public String successfulLoginMsg(){
        return get("successfulLoginMsg");
    }
    public String emptyFieldsValidation(){
        return get("emptyFieldsValidation");
    }
    public String logoutText(){
        return get("logoutText");
    }
    public String flash(){
        return get("flash");
    }
    public String shop(){
        return get("shop");
    }
    public String home(){
        return get("home");
    }
    public String featured(){
        return get("featured");
    }
  public String orderPlacedSuccessfully(){
        return get("orderPlacedSuccessfully");
  }
    }












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

    public static MessageLoader getMessageLoader() {
        return messageLoader;
    }
    public String firstNameErrorMsg(){
        return get("firstNameErrorMessage");
    }
    public String lastNameErrorMessage(){
        return get("lastNameErrorMessage");
    }
    public String zipCodeErrorMessage(){
        return get("zipCodeErrorMessage");

    }
    public String successfulLoginMessage(){
        return get("successfulLoginMessage");
    }
    public String passwordErrorMsg(){
        return get("passwordErrorMsg");
    }
    public String usernameErrorMsg(){
        return get("usernameErrorMsg");
    }
    public String cancelCheckoutMsg(){
        return get("cancelCheckoutMsg");
    }
    public String successfulCheckoutMsg(){
        return get("successfulCheckoutMsg");
    }
    public String checkoutFinishMsg(){
        return get("checkoutFinishMsg");
    }
    public String cancelFinishCheckout(){
       return get("cancelFinishCheckout");
    }
    public String wrongCredentials(){
      return   get("wrongCredentials");
    }









}

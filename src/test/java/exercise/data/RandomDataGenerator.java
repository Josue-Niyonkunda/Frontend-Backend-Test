package exercise.data;

import com.github.javafaker.Faker;

public class RandomDataGenerator {

    private static final Faker faker = new Faker();

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String email() {
        return faker.internet().emailAddress();
    }

    public static String password() {
        return faker.internet().password(8, 16, true, true);
    }
    public static String state(){
        return faker.address().state();
    }
    public static String country(){
        return faker.address().country();
    }
    public static String city(){
        return faker.address().city();
    }
    public static String phone(){
        return faker.phoneNumber().phoneNumber();
    }
    public static String street(){
        return faker.address().streetAddress();
    }

}
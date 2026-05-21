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
}
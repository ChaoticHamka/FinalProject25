package by.itacademy.radzetskaya.ria.Base;

import com.github.javafaker.Faker;

public class TestUtils {

    private final Faker faker = new Faker();
    private final int MAX_RANDOM_VALUE = 9999;

    protected String getRandomInt() {
        return Integer.toString(faker.random().nextInt(MAX_RANDOM_VALUE));
    }

    protected String getRandomFullName() {
        return faker.name().fullName();
    }

    protected String getRandomUserName() {
        return faker.name().username();
    }

    protected String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    protected String getRandomInvalidEmail() {
        return faker.internet().emailAddress().replace("@", "");
    }

    protected String getRandomPassword() {
        return faker.internet().password();
    }
}

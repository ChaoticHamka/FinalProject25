package by.itacademy.radzetskaya.ria.Base;

import com.github.javafaker.Faker;

public class TestUtils{

    private final Faker faker = new Faker();
    private final int MAX_RANDOM_VALUE = 9999;
    private final int MILLIS_IN_SECOND = 1000;

    protected void waiting(int seconds) {
        try {
            Thread.sleep(seconds * MILLIS_IN_SECOND);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected String fakerInt() {
        return Integer.toString(faker.random().nextInt(MAX_RANDOM_VALUE));
    }

    protected String fakerFullName() {
        return faker.name().fullName();
    }

    protected String fakerUserName() {
        return faker.name().username();
    }

    protected String fakerEmail() {
        return faker.internet().emailAddress();
    }

    protected String fakerPassword() {
        return faker.internet().password();
    }
}

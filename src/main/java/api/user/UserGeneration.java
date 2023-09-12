package api.user;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.util.Locale;

public class UserGeneration {

    Faker faker = new Faker(Locale.ENGLISH);

    @Step("Создание дефолтного пользователя")
    public User getDefault() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String name = faker.name().username();
        return new User(email, password, name);
    }

    @Step("Создание пользователя без email")
    public User getDefaultWithOutEmail() {
        String password = faker.internet().password();
        String name = faker.name().username();
        return new User(null, password, name);
    }

    @Step("Создание пользователя без пароля")
    public User getDefaultWithOutPassword() {
        String email = faker.internet().emailAddress();
        String name = faker.name().username();
        return new User(email, null, name);
    }

    @Step("Создание пользователя без имени")
    public User getDefaultWithOutName() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new User(email, password, null);
    }
}
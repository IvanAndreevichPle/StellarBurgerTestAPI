package user;

import api.client.UserClient;
import api.user.User;
import api.user.UserGeneration;
import api.utils.ThreadSleep;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCreateUser {
    private final UserGeneration userGeneration = new UserGeneration();
    private final UserClient userClient = new UserClient();
    private String token;

    @Before
    public void waiting() throws InterruptedException {
        ThreadSleep.run();
    }

    @After
    public void cleanUp() {
        if (token != null) {
            userClient.delete(token);
        }
    }

    @Test
    @DisplayName("Создание пользователя")
    public void userCreate() {
        User user = userGeneration.getDefault();
        ValidatableResponse createUser = userClient.create(user);

        int statusCode = createUser.extract().statusCode();

        if (statusCode == 200) {
            token = createUser.extract().path("accessToken");
        }
        Assert.assertEquals(200, statusCode);
    }

    @Test
    @DisplayName("Создание двух одинаковых пользователей")
    public void equalUser() {
        User user = userGeneration.getDefault();
        ValidatableResponse createUser = userClient.create(user);
        ValidatableResponse createEqualUser = userClient.create(user);

        int statusCode = createUser.extract().statusCode();

        if (statusCode == 200) {
            token = createUser.extract().path("accessToken");
        }
        Assert.assertEquals(403, createEqualUser.extract().statusCode());
    }

    @Test
    @DisplayName("Создание пользователя без email")
    public void userCreateWithOutEmail() {
        User user = userGeneration.getDefaultWithOutEmail();
        ValidatableResponse createUser = userClient.create(user);
        int statusCode = createUser.extract().statusCode();
        if (statusCode == 200) {
            token = createUser.extract().path("accessToken");
        }
        Assert.assertEquals(403, statusCode);
    }

    @Test
    @DisplayName("Создание пользователя без пароля")
    public void userCreateWithOutPassword() {
        User user = userGeneration.getDefaultWithOutPassword();
        ValidatableResponse createUser = userClient.create(user);

        int statusCode = createUser.extract().statusCode();

        if (statusCode == 200) {
            token = createUser.extract().path("accessToken");
        }
        Assert.assertEquals(403, statusCode);
    }

    @Test
    @DisplayName("Создание пользоватлея без имени")
    public void userCreateWithOutName() {
        User user = userGeneration.getDefaultWithOutName();
        ValidatableResponse createUser = userClient.create(user);

        int statusCode = createUser.extract().statusCode();

        if (statusCode == 200) {
            token = createUser.extract().path("accessToken");
        }
        Assert.assertEquals(403, statusCode);
    }
}
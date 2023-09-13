package user;

import api.client.UserClient;
import api.user.User;
import api.user.UserGeneration;
import api.user.UserLogin;
import api.utils.ThreadSleep;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUserLogin {
    private final UserGeneration userGeneration = new UserGeneration();
    private final UserClient userClient = new UserClient();
    private String token;
    private User user;

    @Before
    public void setUp() throws InterruptedException {
        ThreadSleep.run();
        user = userGeneration.getDefault();
        ValidatableResponse createUser = userClient.create(user);
        token = createUser.extract().path("accessToken");
    }

    @After
    public void cleanUp() {
        if (token != null) {
            userClient.delete(token);
        }
    }

    @Test
    @DisplayName("Логин с валидными логином и паролем")
    public void userLogin() {
        ValidatableResponse login = userClient.login(UserLogin.from(user));
        Assert.assertEquals(200, login.extract().statusCode());
    }

    @Test
    @DisplayName("Логин несуществующего пользователя")
    public void notExistingUser() {
        User notExisting = userGeneration.getDefault();
        ValidatableResponse login = userClient.login(UserLogin.from(notExisting));
        Assert.assertEquals(401, login.extract().statusCode());
    }

    @Test
    @DisplayName("Логин с валидным email и неверным паролем")
    public void userLoginWithIncorrectPassword() {
        String email = user.getEmail();
        ValidatableResponse login = userClient.login(UserLogin.create(email, "eiu8whjk"));
        Assert.assertEquals(401, login.extract().statusCode());
    }
}
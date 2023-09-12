package api.client;

import api.BaseConfig;
import api.user.User;
import api.user.UserData;
import api.user.UserLogin;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    BaseConfig config = ConfigFactory.create(BaseConfig.class);
    private final String AUTH_USER = config.authUSER();

    @Step("Cоздание пользователя через API: {{AUTH_USER}}")
    public ValidatableResponse create(User user) {
        return given().log().all()
                .spec(getSpec())
                .body(user)
                .when()
                .post("/api/auth/register")
                .then();
    }

    @Step("Логин пользователя API: {{AUTH_USER}}")
    public ValidatableResponse login(UserLogin userLogin) {
        return given().log().all()
                .spec(getSpec())
                .body(userLogin)
                .when()
                .post("/api/auth/login ")
                .then();
    }

    @Step("Удаление пользователя API: {{AUTH_USER}}")
    public ValidatableResponse delete(String accessToken) {
        return given().log().all()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(AUTH_USER)
                .then();
    }

    @Step("Изменение данных пользователя API: {{AUTH_USER}}")
    public ValidatableResponse changeData(UserData userData, String accessToken) {
        return given().log().all()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .body(userData)
                .when()
                .patch(AUTH_USER)
                .then();
    }

    @Step("Получение данных пользователя API: {{AUTH_USER}}")
    public ValidatableResponse getUserData(String accessToken) {
        return given().log().all()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .when()
                .get(AUTH_USER)
                .then();
    }
}
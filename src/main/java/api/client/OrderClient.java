package api.client;

import api.BaseConfig;
import api.order.Order;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class OrderClient extends Client {

    BaseConfig config = ConfigFactory.create(BaseConfig.class);
    private final String Order_URL = config.orderURL();

    @Step("Создание заказа методом POST: {{Order_URL}}")
    public ValidatableResponse createOrder(Order order, String accessToken) {
        return given().log().all()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .body(order)
                .when()
                .post(Order_URL)
                .then();
    }

    @Step("Получение данных заказа GET: {{Order_URL}}")
    public ValidatableResponse getOrder(String accessToken) {
        return given().log().all()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .when()
                .get(Order_URL)
                .then();
    }
}
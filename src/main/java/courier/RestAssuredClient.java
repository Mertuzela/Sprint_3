package courier;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient {
    protected final String URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    protected final String REGISTRATION = "/courier";
    protected final String LOGIN_URL = "/courier/login";
    protected final String ORDERS_URL = "/orders";
    protected final String COURIER = "/courier/{courierId}";
    protected final String ORDER_DATA = "/orders/track?t=";
    protected final String login_error_404 = "{\"code\":404,\"message\":\"Учетная запись не найдена\"}";
    protected final String login_error_400 = "{\"code\":400,\"message\":\"Недостаточно данных для входа\"}";
    protected final String createCourier_ok_201 = "{\"ok\":true}";
    protected final String createCourier_error_400 = "{\"code\":400,\"message\":\"Недостаточно данных для создания учетной записи\"}";
    protected final String createCourier_error_409 = "{\"code\":409,\"message\":\"Этот логин уже используется. Попробуйте другой.\"}";
    protected final RequestSpecification reqSpec = RestAssured.given().header("Content-type", "application/json", new Object[0]).baseUri("https://qa-scooter.praktikum-services.ru/api/v1");

    public RestAssuredClient() {
    }
}

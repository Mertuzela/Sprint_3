package courier;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {

    protected final String URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    protected final String REGISTRATION = "/courier";
    protected final String LOGIN_URL = REGISTRATION + "/login";
    protected final String ORDERS_URL = "/orders";
    protected final String COURIER = REGISTRATION + "/{courierId}";
    protected final String ORDER_DATA = ORDERS_URL + "/track?t=";

    protected final String login_error_404 = "{\"code\":404,\"message\":\"Учетная запись не найдена\"}";
    protected final String login_error_400 = "{\"code\":400,\"message\":\"Недостаточно данных для входа\"}";
    protected final String createCourier_ok_201 = "{\"ok\":true}";
    protected final String createCourier_error_400 = "{\"code\":400,\"message\":\"Недостаточно данных для создания учетной записи\"}";
    protected final String createCourier_error_409 = "{\"code\":409,\"message\":\"Этот логин уже используется. Попробуйте другой.\"}";

    protected final RequestSpecification reqSpec = given()
            .header("Content-type","application/json")
            .baseUri(URL);
}

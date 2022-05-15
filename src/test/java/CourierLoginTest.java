import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CourierLoginTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }
//    курьер может авторизоваться;+
//    для авторизации нужно передать все обязательные поля;+
//    система вернёт ошибку, если неправильно указать логин или пароль;+
//    если какого-то поля нет, запрос возвращает ошибку;
//    если авторизоваться под несуществующим пользователем, запрос возвращает ошибку;
//    успешный запрос возвращает id.+

    @Test // Авторизация
    public void loginCourier() {
        CourierCreate courierCreate = new CourierCreate("ninja","1234");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(courierCreate)
                        .when()
                        .post("/api/v1/courier/login");
        response.then().assertThat().body("id", notNullValue())
                .and()
                .statusCode(200);
    }

    @Test // Авторизация пустое поле
    public void loginCourierEmptyBody() {
        CourierCreate courierCreate = new CourierCreate();
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(courierCreate)
                        .when()
                        .post("/api/v1/courier/login");
        response.then().assertThat().statusCode(400);
    }

    @Test // Авторизация неверный логин
    public void loginCourierIncorrectLogin() {
        CourierCreate courierCreate = new CourierCreate("ninj1a","1234");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(courierCreate)
                        .when()
                        .post("/api/v1/courier/login");
        response.then().assertThat().statusCode(404);
    }

    @Test // Авторизация неверный пароль
    public void loginCourierIncorrectPassword() {
        CourierCreate courierCreate = new CourierCreate("ninja","12341234");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(courierCreate)
                        .when()
                        .post("/api/v1/courier/login");
        response.then().assertThat().statusCode(404);
    }
}

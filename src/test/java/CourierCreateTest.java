import courier.Courier;
import courier.CourierClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CourierCreateTest {
    private CourierClient courierClient;

    @Before
    public void setUp() {
        new CourierClient();
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test //Полный флоу создания
    public void createCourierFull () {
        Courier courier = Courier.getRandom();
        boolean created = courierClient.create(courier);

    }
    @Test // Пустые поля запроса
    public void createCourierEmptyBody () {
        CourierCreate courierCreate = new CourierCreate();
        Response response =
        given()
                .header("Content-type", "application/json")
                .and()
                .body(courierCreate)
                .when()
                .post("/api/v1/courier");
                response.then().assertThat().statusCode(400)
                        .and()
                        .body(equalTo("{\"code\":400,\"message\":\"Недостаточно данных для создания учетной записи\"}"));
    }
}

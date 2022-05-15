import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest { // ПОРАБОТАТЬ НАД ЦВЕТАМИ
//    Проверь, что когда создаёшь заказ:
//    можно указать один из цветов — BLACK или GREY;
//    можно указать оба цвета;
//    можно совсем не указывать цвет;
//    тело ответа содержит track.

    private final String[] color;



    public CreateOrderTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getOrderData() {
        return new Object[][]{
                {new String[] {"BLACK"}},
                {new String[] {"GREY"}},
                {new String[] {"BLACK", "GREY"}},
                {new String[] {""}}

        };
    }


    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void createOrder() {
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(getOrderData())
                        .when()
                        .post("/api/v1/orders");
        response.then().body(notNullValue());

    }
}

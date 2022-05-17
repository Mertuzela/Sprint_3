import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.OrderData;

import static org.apache.http.HttpStatus.*;

@RunWith(Parameterized.class)
public class CreateOrderTest extends RestAssuredClient {

    private final String[] color;

    public CreateOrderTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3}")
    public static Object[][] getOrderData() {
        return new Object[][]{
                {new String[] {"BLACK"}},
                {new String[] {"GREY"}},
                {new String[] {"BLACK", "GREY"}},
                {new String[] {""}},
        };
    }

    @Test
    @DisplayName("Create order with/without color")
    @Description("Check for create order with/without color in body request")
    public void createOrderTestWithParam() {
        OrderData orderData = new OrderData();
        ValidatableResponse response = orderData.orderCreate(color)
                .assertThat()
                .statusCode(SC_CREATED);
        int track = response
                .extract()
                .path("track");
        Assert.assertNotEquals(0,track);
    }
}
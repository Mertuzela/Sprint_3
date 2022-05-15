import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.OrderData;

@RunWith(Parameterized.class)
public class CreateOrderTest extends RestAssuredClient {

    private final String color;
    private final int unexpected = 0;

    public CreateOrderTest(String color) {
        this.color = color;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3}")
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"{\"color\":[\"BLACK\"]}"},
                {"{\"color\":[\"GREY\"]}"},
                {"{\"color\":[\"\"]}"},
                {"{\"color\":[\"BLACK\",\"GREY\"]}"}
        };
    }

    @Test
    @DisplayName("Create order with/without color")
    @Description("Check for create order with/without color in body request")
    public void createOrderTestWithParam() {
        OrderData orderData = new OrderData();
        orderData.orderCreate(color);
       Assert.assertNotEquals(unexpected, orderData.orderTrack());
       orderData.getOrderData();
    }
}
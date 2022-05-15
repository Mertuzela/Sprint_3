//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.yandex.praktikum.OrderData;

@RunWith(Parameterized.class)
public class CreateOrderTest extends RestAssuredClient {
    private final String color;
    private final int unexpected = 0;

    public CreateOrderTest(String color) {
        this.color = color;
    }

    @Parameters(
        name = "Тестовые данные: {0} {1} {2} {3}"
    )
    @Step("Data for create order")
    public static Object[][] getOrderData() {
        return new Object[][]{{"{\"color\":[\"BLACK\"]}"}, {"{\"color\":[\"GREY\"]}"}, {"{\"color\":[\"\"]}"}, {"{\"color\":[\"BLACK\",\"GREY\"]}"}};
    }

    @Test
    @DisplayName("Create order with/without color")
    @Description("Check for create order with/without color in body request")
    public void createOrderTestWithParam() {
        OrderData orderData = new OrderData();
        orderData.orderCreate(this.color);
        Assert.assertNotEquals(0L, (long)orderData.orderTrack());
        orderData.getOrderData();
    }
}

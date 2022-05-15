import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import ru.yandex.praktikum.FullResponse;
import static org.hamcrest.CoreMatchers.notNullValue;


public class ListOrderTest extends RestAssuredClient {

    @Test
    @DisplayName("Get order list")
    @Description("Check for get order list and deserialization in JAVA class")
    public void getOrderList() {
     FullResponse response = reqSpec
                .when()
                .post(ORDERS_URL)
                .body().as(FullResponse.class);
        MatcherAssert.assertThat(response,notNullValue());
    }
}

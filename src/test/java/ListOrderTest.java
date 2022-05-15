import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import ru.yandex.praktikum.FullResponse;

public class ListOrderTest extends RestAssuredClient {
    public ListOrderTest() {
    }

    @Test
    @DisplayName("Get order list")
    @Description("Check for get order list and deserialization in JAVA class")
    public void getOrderList() {
        FullResponse response = (FullResponse)((Response)this.reqSpec.when().post("/orders", new Object[0])).body().as(FullResponse.class);
        MatcherAssert.assertThat(response, CoreMatchers.notNullValue());
    }
}

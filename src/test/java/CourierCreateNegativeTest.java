import courier.Courier;
import courier.CourierClient;
import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourierCreateNegativeTest extends RestAssuredClient {


        @Test
        @DisplayName("Create courier without password")
        @Description("Check for create courier without password in request")
        public void createCourierWithoutPassword() {
            Courier courier = Courier.getRandomWithoutPassword();
            boolean create = new CourierClient().createWithoutPassword(courier);
            assertTrue(create);
        }

    @Test
    @DisplayName("Create Courier with empty body request")
    @Description("Check for create courier with empty body request")
    public void createCourierEmptyBody() {

        boolean create = new CourierClient().createWithEmptyBody();
        assertTrue(create);
    }

    @Test
    @DisplayName("Create same courier")
    @Description("Check for create two identical courier")
    public void createSameCourier() {
            Courier courier = Courier.getRandom();
            boolean create = new CourierClient().createSameCourier(courier);
            assertTrue(create);
    }
}
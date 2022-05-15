import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CourierCreateTest extends RestAssuredClient {

    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @After
    public void teardown() {
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Create courier")
    @Description("Check for create courier with valid data and get courier ID")
    public void createCourierFull() {
        Courier courier = Courier.getRandom();
        boolean created = new CourierClient().create(courier);

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);

        assertTrue(created);
        assertNotEquals(0, courierId);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourierCreateTest extends RestAssuredClient {
    private CourierClient courierClient;
    private int courierId;

    public CourierCreateTest() {
    }

    @Before
    public void setUp() {
        this.courierClient = new CourierClient();
    }

    @After
    public void teardown() {
        this.courierClient.delete(this.courierId);
    }

    @Test
    @DisplayName("Create courier")
    @Description("Check for create courier with valid data and get courier ID")
    public void createCourierFull() {
        Courier courier = Courier.getRandom();
        boolean created = (new CourierClient()).create(courier);
        CourierCredentials creds = CourierCredentials.from(courier);
        this.courierId = this.courierClient.login(creds);
        Assert.assertTrue(created);
        Assert.assertNotEquals(0L, (long)this.courierId);
    }
}

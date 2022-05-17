import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CourierLoginTest extends RestAssuredClient {

    private CourierClient courierClient;
    private Courier courier;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = Courier.getRandom();

    }

    @Test
    @DisplayName("Login courier")
    @Description("Check for login courier in system with valid data")
    public void loginCourierInSystemWithValidData() {
        courierClient.createCourier(courier);
        CourierCredentials credentials = CourierCredentials.from(courier);
        int courierId = courierClient.loginCourier(credentials)
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .path("id");
        courierClient.deleteCourier(courierId);
    }

    @Test
    @DisplayName("Login courier with incorrect login")
    @Description("Check for login courier in system with incorrect login")
    public void loginCourierWithIncorrectLogin() {
        Courier courier = new Courier("","1234","");
        CourierCredentials credentials = CourierCredentials.from(courier);
        courierClient.loginCourier(credentials)
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .and()
                .body(equalTo(login_error_400));
    }
    @Test
    @DisplayName("Login courier with empty password")
    @Description("Check for login courier in system with empty password")
    public void loginCourierWithIncorrectPassword() {
        Courier courier = new Courier("ninja","","");
        CourierCredentials credentials = CourierCredentials.from(courier);
        courierClient.loginCourier(credentials)
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .and()
                .body(equalTo(login_error_400));
    }

    @Test
    @DisplayName("Login courier with invalid data")
    @Description("Check for login courier in system with incorrect password")
    public void loginCourierWithInvalidData() {
        Courier courier = new Courier("ninja","0","");
        CourierCredentials credentials = CourierCredentials.from(courier);
        courierClient.loginCourier(credentials)
                .assertThat()
                .statusCode(SC_NOT_FOUND)
                .and()
                .body(equalTo(login_error_404));
    }
}
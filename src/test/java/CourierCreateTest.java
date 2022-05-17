import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import courier.RestAssuredClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CourierCreateTest extends RestAssuredClient {

    private CourierClient courierClient;
    private int courierId;
    private Courier courier;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = Courier.getRandom();
    }

    @After
    public void teardown() {
        if (courierId != 0) {
            courierClient.deleteCourier(courierId);
        }
    }

    @Test
    @DisplayName("Create courier")
    @Description("Check for create courier with valid data and get courier ID")
    public void createCourier() {

        ValidatableResponse response = courierClient.createCourier(courier);
        boolean isCourierCreate = response
                .extract()
                .path("ok");

        CourierCredentials credentials = CourierCredentials.from(courier);
        courierId = courierClient.loginCourier(credentials)
                                .extract()
                                .path("id");
        response.assertThat()
                .statusCode(SC_CREATED)
                .and()
                .body(equalTo(createCourier_ok_201));
        assertTrue(isCourierCreate);
    }

    @Test
    @DisplayName("Create courier without password")
    @Description("Check for create courier without password in request")
    public void createCourierWithoutPassword() {
        courier.setPassword("");
        courierClient.createCourier(courier)
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .and()
                .body(equalTo(createCourier_error_400));
    }
    @Test
    @DisplayName("Create Courier with empty body request")
    @Description("Check for create courier with empty body request")
    public void createCourierWithEmptyBodyRequest() {
        courier.setPassword("");
        courier.setLogin("");
        courierClient.createCourier(courier)
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .and()
                .body(equalTo(createCourier_error_400));
    }

    @Test
    @DisplayName("Create Courier With Same Login")
    @Description("Check for create two identical courier")
    public void createCourierWithSameLogin() {
        courierClient.createCourier(courier);
        courier.setLogin(courier.getLogin());
        courier.setPassword(courier.getPassword()+"9320");
        courierClient.createCourier(courier)
                .assertThat()
                .statusCode(SC_CONFLICT)
                .and()
                .body(equalTo(createCourier_error_409));
    }

    @Test
    @DisplayName("Create two same courier")
    @Description("Check for create two identical courier")
    public void createTwoIdentialCourier() {
       courierClient.createCourier(courier)
                .assertThat()
                .statusCode(SC_CREATED);
        CourierCredentials credentials = CourierCredentials.from(courier);
        courierId = courierClient.loginCourier(credentials)
                .extract()
                .path("id");
        courierClient.createCourier(courier)
                .assertThat()
                .statusCode(SC_CONFLICT)
                .and()
                .body(equalTo(createCourier_error_409));
    }
}
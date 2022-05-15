package courier;

import static io.restassured.RestAssured.given;

public class CourierClient extends RestAssuredClient{


private String REGISTRATION = "/courier";
private String LOGIN_URL = "courier/login";
public boolean create(Courier courier) {
   return reqSpec
            .body(courier)
            .when()
            .post(REGISTRATION)
            .then().log().all()
            .assertThat()
            .statusCode(201)
            .extract()
            .path("ok");
}

}

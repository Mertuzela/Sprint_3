package courier;

import io.restassured.response.ValidatableResponse;

public class CourierClient extends RestAssuredClient{

   public ValidatableResponse createCourier(Courier courier) {
       return reqSpec
               .body(courier)
               .when()
               .post(REGISTRATION)
               .then().log().all();
   }

public ValidatableResponse loginCourier(CourierCredentials credentials) {
  return reqSpec
           .body(credentials)
           .when()
           .post(LOGIN_URL)
           .then().log().all();
}

public void deleteCourier(int courierId) {
    reqSpec.pathParam("courierId", courierId)
            .when()
            .delete(COURIER)
            .then().log().all();
    }
}
package ru.yandex.praktikum;

import courier.RestAssuredClient;

public class OrderData extends RestAssuredClient {
    private int track;

    public int orderCreate(String color) {
       track = reqSpec
                .body(color)
                .when()
                .post(ORDERS_URL)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("track");
        return track;
    }

    public int orderTrack(){
        return track;
    }
    public void getOrderData() {
       reqSpec
                .when()
                .get(ORDER_DATA+track)
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

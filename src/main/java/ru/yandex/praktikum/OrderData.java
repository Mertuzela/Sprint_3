package ru.yandex.praktikum;

import courier.RestAssuredClient;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OrderData extends RestAssuredClient {
    private int track;

    public OrderData() {
    }

    public int orderCreate(String color) {
        this.track = (Integer)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.body(color).when().post("/orders", new Object[0])).then()).log().all()).assertThat()).statusCode(201)).extract().path("track", new String[0]);
        return this.track;
    }

    public int orderTrack() {
        return this.track;
    }

    public void getOrderData() {
        ((ValidatableResponse)((ValidatableResponse)((ValidatableResponse)((Response)this.reqSpec.when().get("/orders/track?t=" + this.track, new Object[0])).then()).log().all()).assertThat()).statusCode(200);
    }
}

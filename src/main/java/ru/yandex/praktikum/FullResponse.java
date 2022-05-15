package ru.yandex.praktikum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties("track")
public class FullResponse {
    private List<ResponseJSON> orders;

    public List<ResponseJSON> getOrders() {
        return orders;
    }
    public void setOrders(List<ResponseJSON> orders) {
        this.orders = orders;
    }
}

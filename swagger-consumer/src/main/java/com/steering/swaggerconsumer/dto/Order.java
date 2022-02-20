package com.steering.swaggerconsumer.dto;

import java.util.List;

public class Order {
    private int id;
    private String customerEmail;
    private List<String> dishList;

    public Order(int id, String customerEmail, List<String> dishList) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.dishList = dishList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<String> getDishList() {
        return dishList;
    }

    public void setDishList(List<String> dishList) {
        this.dishList = dishList;
    }
}

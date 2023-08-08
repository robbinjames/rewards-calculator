package com.demo.rewardscalculator.model;

import com.demo.rewardscalculator.data.Points;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerRewards {

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("points")
    private List<Points> pointList;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Points> getPointList() {
        return pointList;
    }

    public void setPointList(List<Points> pointList) {
        this.pointList = pointList;
    }
}

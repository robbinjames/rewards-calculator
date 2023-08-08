package com.demo.rewardscalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Month;
import java.util.List;
import java.util.Map;

public class RewardResponse {

    @JsonProperty("rewards")
    private List<CustomerRewards> customerRewardsList;


    public List<CustomerRewards> getCustomerRewardsList() {
        return customerRewardsList;
    }

    public void setCustomerRewardsList(List<CustomerRewards> customerRewardsList) {
        this.customerRewardsList = customerRewardsList;
    }

//    private Map<String, Map<Month, Integer>> rewardMap;
//
//    public Map<String, Map<Month, Integer>> getRewardMap() {
//        return rewardMap;
//    }
//
//    public void setRewardMap(Map<String, Map<Month, Integer>> rewardMap) {
//        this.rewardMap = rewardMap;
//    }
}

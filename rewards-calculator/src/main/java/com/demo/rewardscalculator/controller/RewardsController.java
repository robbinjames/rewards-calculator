package com.demo.rewardscalculator.controller;

import com.demo.rewardscalculator.model.RewardResponse;
import com.demo.rewardscalculator.service.RewardsCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

    @Autowired
    RewardsCalculatorService rewardsCalculatorService;

    @RequestMapping("/")
    String hello() {
        return "Demo Test";
    }

    @GetMapping("/calculate")
    public ResponseEntity<RewardResponse> calculateRewards() {
        Map<String, Map<Month, Integer>> rewardsMap = new HashMap<>();
        return ResponseEntity.ok(rewardsCalculatorService.calculateRewards());
    }
}

package com.demo.rewardscalculator;

import com.demo.rewardscalculator.controller.RewardsController;
import com.demo.rewardscalculator.service.RewardsCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest
class RewardsCalculatorServiceApplicationTests {

	@Autowired
	RewardsController rewardsController;

	@Autowired
	RewardsCalculatorService rewardsCalculatorService;

	@Test
	void contextLoads() {

		assertNotNull(rewardsCalculatorService);
		assertNotNull(rewardsController);
	}
}

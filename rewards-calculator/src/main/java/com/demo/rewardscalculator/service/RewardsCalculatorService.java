package com.demo.rewardscalculator.service;

import com.demo.rewardscalculator.model.CustomerRewards;
import com.demo.rewardscalculator.data.Points;
import com.demo.rewardscalculator.model.RewardResponse;
import org.springframework.stereotype.Service;
import com.demo.rewardscalculator.data.Customer;
import com.demo.rewardscalculator.data.Transaction;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardsCalculatorService {

    private final Map<Long, Customer> customers = new HashMap<>();
    private final List<Transaction> transactions = new ArrayList<>();

    public RewardResponse calculateRewards() {

        RewardResponse rewardResponse = new RewardResponse();
        Map<String, Map<Month, Integer>> CustomerRewardsMap = new HashMap<>();

        // Populate some sample data for demonstration
        Customer customer1 = new Customer(1L, "Robin James");
        Customer customer2 = new Customer(2L, "Aiden James");
        customers.put(customer1.getId(), customer1);
        customers.put(customer2.getId(), customer2);

        transactions.add(new Transaction(1L, customer1, LocalDate.of(2023, 6, 10), 200.0));
        transactions.add(new Transaction(2L, customer1, LocalDate.of(2023, 7, 5), 120.0));
        transactions.add(new Transaction(2L, customer1, LocalDate.of(2023, 8, 7), 120.0));
        transactions.add(new Transaction(3L, customer2, LocalDate.of(2023, 6, 15), 80.0));
        transactions.add(new Transaction(4L, customer2, LocalDate.of(2023, 7, 25), 50.0));
        transactions.add(new Transaction(2L, customer2, LocalDate.of(2023, 8, 7), 120.0));

        transactions.add(new Transaction(1L, customer1, LocalDate.of(2023, 6, 7), 200.0));
        transactions.add(new Transaction(2L, customer1, LocalDate.of(2023, 7, 7), 120.0));
        transactions.add(new Transaction(2L, customer1, LocalDate.of(2023, 8, 7), 120.0));
        transactions.add(new Transaction(3L, customer2, LocalDate.of(2023, 6, 7), 80.0));
        transactions.add(new Transaction(4L, customer2, LocalDate.of(2023, 7, 7), 50.0));
        transactions.add(new Transaction(2L, customer2, LocalDate.of(2023, 8, 7), 120.0));

        // Calculate rewards for each customer per month
        for (Transaction transaction : transactions) {
            int rewardPoints = calculateRewardPoints(transaction.getTransactionAmount());
            Month month = transaction.getTransactionDate().getMonth();
            long customerId = transaction.getCustomer().getId();

            CustomerRewardsMap.putIfAbsent(customers.get(customerId).getName(), new HashMap<>());
            CustomerRewardsMap.get(customers.get(customerId).getName()).merge(month, rewardPoints, Integer::sum);
        }

        List<CustomerRewards> rList = new ArrayList<>();
        CustomerRewardsMap.forEach((k,v) ->{
            CustomerRewards customerRewards = new CustomerRewards();
            List<Points> pointsList = new ArrayList<>();

            customerRewards.setCustomerName(k);
            v.forEach((x,y) ->{
                Points points = new Points();
                points.setMonth(x);
                points.setPoints(y);
                pointsList.add(points);
            });
            customerRewards.setPointList(pointsList);

            rList.add(customerRewards);
        });
        rewardResponse.setCustomerRewardsList(rList);
        return rewardResponse;
    }

    private int calculateRewardPoints(double amount) {
        if (amount > 100) {
            return (int) (2 * (amount - 100) + Math.min(50, amount - 50));
        } else if (amount > 50) {
            return (int) (amount - 50);
        }
        return 0;
    }
}
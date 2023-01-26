package com.madan.vivek.javacodingtask.service;

import com.madan.vivek.javacodingtask.dto.PurchaseDetails;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    public static final int LOWER_LIMIT = 50;
    public static final int HIGHER_LIMIT = 100;
    public int calculateRewardPoints(PurchaseDetails purchaseDetails){
        return purchaseDetails.getPurchaseTransactions().stream().map(t -> {
            double greaterThanHigherLimit = 0;
            int rewardPoints = 0;

            if(t.getTotalCost() > HIGHER_LIMIT){
                greaterThanHigherLimit = t.getTotalCost() - HIGHER_LIMIT;

                if(greaterThanHigherLimit> 0){
                    rewardPoints = (int) greaterThanHigherLimit * 2;
                    rewardPoints += (HIGHER_LIMIT - LOWER_LIMIT) * 1;
                }
            } else if(t.getTotalCost() >= LOWER_LIMIT && t.getTotalCost() <= HIGHER_LIMIT){
                rewardPoints = (HIGHER_LIMIT - LOWER_LIMIT) * 1;
            }
            return rewardPoints;

        }).reduce(0, Integer::sum);
    }
}

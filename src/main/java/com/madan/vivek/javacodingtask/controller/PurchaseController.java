package com.madan.vivek.javacodingtask.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madan.vivek.javacodingtask.dto.PurchaseDetails;
import com.madan.vivek.javacodingtask.service.RewardService;

@RestController
public class PurchaseController {

    private RewardService rewardService;
    public PurchaseController(RewardService rewardService){
        this.rewardService = rewardService;
    }

    @PostMapping(path="/calculateReward", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> calculateReward(@RequestBody PurchaseDetails purchaseDetails){
    	Map<String, String> resultMap = new HashMap<>();
    	resultMap.put("status", "SUCCESS");
    	resultMap.put("rewards", String.valueOf(rewardService.calculateRewardPoints(purchaseDetails)));
        return ResponseEntity.ok().body(resultMap);
    }

}

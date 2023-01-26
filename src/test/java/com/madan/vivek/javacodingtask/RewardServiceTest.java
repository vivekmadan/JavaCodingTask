package com.madan.vivek.javacodingtask;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.madan.vivek.javacodingtask.dto.PurchaseDetails;
import com.madan.vivek.javacodingtask.dto.PurchaseTransaction;
import com.madan.vivek.javacodingtask.service.RewardService;

@ExtendWith(MockitoExtension.class)
class RewardServiceTest {

	@InjectMocks
	private RewardService rewardService;

	@Test
	void testCalculateRewardPoints_AmountMoreThan100() {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		PurchaseTransaction transaction = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(120)
				.build();
		purchaseDetails.setPurchaseTransactions(Arrays.asList(transaction));
		int reward = rewardService.calculateRewardPoints(purchaseDetails);
		assertThat(reward).isEqualTo(90);
	}
	
	@Test
	void testCalculateRewardPoints_AmountIs100() {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		PurchaseTransaction transaction = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(100)
				.build();
		purchaseDetails.setPurchaseTransactions(Arrays.asList(transaction));
		int reward = rewardService.calculateRewardPoints(purchaseDetails);
		assertThat(reward).isEqualTo(50);
	}

	@Test
	void testCalculateRewardPoints_AmountBetween50And100() {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		PurchaseTransaction transaction = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(70)
				.build();
		purchaseDetails.setPurchaseTransactions(Arrays.asList(transaction));
		int reward = rewardService.calculateRewardPoints(purchaseDetails);
		assertThat(reward).isEqualTo(50);
	}
	
	@Test
	void testCalculateRewardPoints_AmountIs50() {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		PurchaseTransaction transaction = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(50)
				.build();
		purchaseDetails.setPurchaseTransactions(Arrays.asList(transaction));
		int reward = rewardService.calculateRewardPoints(purchaseDetails);
		assertThat(reward).isEqualTo(50);
	}
	
	@Test
	void testCalculateRewardPoints_AmountLessThan50() {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		PurchaseTransaction transaction = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(40)
				.build();
		purchaseDetails.setPurchaseTransactions(Arrays.asList(transaction));
		int reward = rewardService.calculateRewardPoints(purchaseDetails);
		assertThat(reward).isEqualTo(0);
	}
	
	@Test
	void testCalculateRewardPoints_MultipleTransaction() {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		PurchaseTransaction transaction1 = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(50)
				.build();
		
		PurchaseTransaction transaction2 = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(100)
				.build();
		
		PurchaseTransaction transaction3 = PurchaseTransaction.builder()
				.transactionId(1)
				.customerName("Customer Name")
				.item("Item 1")
				.quantity(1)
				.price(120)
				.totalCost(120)
				.build();
		
		purchaseDetails.setPurchaseTransactions(Arrays.asList(transaction1,transaction2,transaction3));
		int reward = rewardService.calculateRewardPoints(purchaseDetails);
		assertThat(reward).isEqualTo(190);
	}
}

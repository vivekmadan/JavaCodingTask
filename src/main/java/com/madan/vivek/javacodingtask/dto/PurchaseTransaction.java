package com.madan.vivek.javacodingtask.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
public class PurchaseTransaction {
    private int transactionId;
    private String item;
    private int price;
    private int quantity;
    private int totalCost;
    private String customerName;
    private String purchaseDate;
}

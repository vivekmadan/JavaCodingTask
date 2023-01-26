package com.madan.vivek.javacodingtask.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class PurchaseDetails {
    List<PurchaseTransaction> purchaseTransactions;
}

package org.example.mybank.entity.myObject;

import lombok.Data;

import java.util.Date;

@Data
public class transactionView {
    private String accountNumber;
    private String transactionType;
    private String transactionAmount;
    private String transactionTime;
    private String transferToAccountNumber;
}

package org.example.mybank.entity.myObject;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class transaction_param {
    private String accountNumber;
    private String password;
    private double amount;
    private String toAccountNumber;
    private String toAccountName;
}

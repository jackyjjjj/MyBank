package org.example.mybank.entity.myObject;


import lombok.Data;

@Data
public class transaction_param {
    private String accountNumber;
    private String password;
    private Integer amount;
    private String toAccountNumber;
    private String toAccountName;
}

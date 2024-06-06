package org.example.mybank.entity.myObject;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class addAccount_param {
    private Integer accountType;

    private String accountNumber;

    private BigDecimal balance;

    private Integer isValid;

    private Integer quota;

    private Integer staffId;




}

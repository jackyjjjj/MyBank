package org.example.mybank.entity.myObject;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class addAccount_param {
    private Integer accountType = 1;

    private String accountNumber;

    private String password;

    private BigDecimal balance = BigDecimal.ZERO;

    private Integer isValid = 1;

    private Integer quota = 1;

    private Integer staffId;

    private String userId;

}

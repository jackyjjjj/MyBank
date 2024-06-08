package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @TableName transaction_record
 */
@TableName(value ="transaction_record")
@Data
public class TransactionRecord implements Serializable {
    @TableId(value="transactionId",type = IdType.AUTO)
    private Integer transactionId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String accountId;

    private Integer transactionType;

    private BigDecimal transactionAmount;

    private Date transactionTime;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String transferToAccountId;

    private static final long serialVersionUID = 1L;
}
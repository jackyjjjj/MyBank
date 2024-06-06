package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName transaction_record
 */
@TableName(value ="transaction_record")
@Data
public class TransactionRecord implements Serializable {
    private Integer transactionId;

    private Integer accountId;

    private Integer transactionType;

    private BigDecimal transactionAmount;

    private Date transactionTime;

    private Integer transferToAccountId;

    private static final long serialVersionUID = 1L;
}
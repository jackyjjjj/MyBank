package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName account_info
 */
@TableName(value ="account_info")
@Data
public class AccountInfo implements Serializable {
    private Integer accountId;

    private Integer accountType;

    private String accountNumber;

    private BigDecimal balance;

    private Date createTime;

    private Date updateTime;

    private Integer isValid;

    private Integer quota;

    private Integer staffId;

    private static final long serialVersionUID = 1L;
}
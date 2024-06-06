package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @TableName account_info
 */
@TableName(value ="account_info")
@Data
public class AccountInfo implements Serializable {
    @TableId(value = "accountId",type= IdType.AUTO)
    private Integer accountId;

    private Integer accountType;

    private String accountNumber;

    private BigDecimal balance;

    private Date createTime;

    private Date updateTime;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @TableLogic
    private Integer isValid;

    private Integer quota;

    private Integer staffId;

    private static final long serialVersionUID = 1L;
}
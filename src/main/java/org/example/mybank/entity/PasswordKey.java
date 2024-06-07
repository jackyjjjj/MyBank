package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName PasswordKey
 */
@TableName(value ="PasswordKey")
@Data
public class PasswordKey implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String accountNumber;

    /**
     * 
     */
    private String passwordKey;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
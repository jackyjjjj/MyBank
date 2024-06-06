package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @TableName phone_password
 */
@TableName(value ="phone_password")
@Data
public class PhonePassword implements Serializable {
    @TableId(value="passwordId",type = IdType.AUTO)
    private Integer passwordId;

    private String phoneNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @TableField(select = false)
    private String password;

    private static final long serialVersionUID = 1L;


}
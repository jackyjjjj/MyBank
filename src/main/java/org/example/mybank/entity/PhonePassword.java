package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName phone_password
 */
@TableName(value ="phone_password")
@Data
public class PhonePassword implements Serializable {
    private Integer passwordId;

    private String phoneNumber;

    private String password;

    private static final long serialVersionUID = 1L;
}
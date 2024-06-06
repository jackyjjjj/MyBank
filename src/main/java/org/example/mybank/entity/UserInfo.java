package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo implements Serializable {
    @TableId(value="userId",type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private Integer gender;

    private String identityNumber;

    private String phoneNumber;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Integer isValid;

    private static final long serialVersionUID = 1L;
}
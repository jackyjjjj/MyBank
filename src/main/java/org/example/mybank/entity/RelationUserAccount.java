package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName relation_user_account
 */
@TableName(value ="relation_user_account")
@Data
public class RelationUserAccount implements Serializable {
    private Integer relationId;

    private Integer userId;

    private Integer accountId;

    private String password;

    private static final long serialVersionUID = 1L;
}
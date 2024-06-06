package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName relation_user_account
 */
@TableName(value ="relation_user_account")
@Data
public class RelationUserAccount implements Serializable {
    @TableId(value="relationId",type = IdType.AUTO)
    private Integer relationId;

    private Integer userId;

    private Integer accountId;

    private String password;

    private static final long serialVersionUID = 1L;
}
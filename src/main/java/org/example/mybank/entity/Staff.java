package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName staff
 */
@TableName(value ="staff")
@Data
public class Staff implements Serializable {
    @TableId(value="staffId",type = IdType.AUTO)
    private Integer staffId;

    private String staffName;

    private String password;

    private static final long serialVersionUID = 1L;
}
package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName staff
 */
@TableName(value ="staff")
@Data
public class Staff implements Serializable {
    private Integer staffId;

    private String staffName;

    private static final long serialVersionUID = 1L;
}
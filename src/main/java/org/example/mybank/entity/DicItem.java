package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName dicitem
 */
@TableName(value ="dicitem")
@Data
public class DicItem implements Serializable {
    private Integer dicItemId;

    private Integer dicTypeCode;

    private Integer dicItemCode;

    private String dicItemName;

    private static final long serialVersionUID = 1L;
}
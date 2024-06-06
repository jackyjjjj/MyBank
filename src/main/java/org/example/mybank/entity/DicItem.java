package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName dicitem
 */
@TableName(value ="dicitem")
@Data
public class DicItem implements Serializable {
    @TableId(value="dicItemId",type = IdType.AUTO)
    private Integer dicItemId;

    private Integer dicTypeCode;

    private Integer dicItemCode;

    private String dicItemName;

    private static final long serialVersionUID = 1L;
}
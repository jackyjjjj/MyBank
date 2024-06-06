package org.example.mybank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName dictype
 */
@TableName(value ="dictype")
@Data
public class DicType implements Serializable {
    @TableId(value="dicTypeId",type = IdType.AUTO)
    private Integer dicTypeId;

    private Integer dicTypeCode;

    private String dicTypeName;

    private static final long serialVersionUID = 1L;
}
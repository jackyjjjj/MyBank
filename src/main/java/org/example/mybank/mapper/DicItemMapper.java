package org.example.mybank.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.example.mybank.entity.DicItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
* @author Mr.J
* @description 针对表【dicitem】的数据库操作Mapper
* @createDate 2024-06-05 22:50:01
* @Entity org.example.mybank.entity.Dicitem
*/
public interface DicItemMapper extends BaseMapper<DicItem> {
    @MapKey("dicTypeCode")
    Map<Integer,Integer> selectTypeItem();

}





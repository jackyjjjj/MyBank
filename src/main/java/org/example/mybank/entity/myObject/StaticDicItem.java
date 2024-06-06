package org.example.mybank.entity.myObject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.val;
import org.example.mybank.entity.DicItem;
import org.example.mybank.mapper.DicItemMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class StaticDicItem {
    public static Map<Integer, Set<Integer>> map;


    public StaticDicItem(DicItemMapper dicItemMapper) {
        List<DicItem> dicItems = dicItemMapper.selectList(new QueryWrapper<>());
        for(DicItem dicItem : dicItems){

        }

    }
}

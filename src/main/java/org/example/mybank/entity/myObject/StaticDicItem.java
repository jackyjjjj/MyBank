package org.example.mybank.entity.myObject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.val;
import org.example.mybank.entity.DicItem;
import org.example.mybank.mapper.DicItemMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StaticDicItem {
    public static Map<Integer, Map<Integer, String>> MAP = new HashMap<>();


    public StaticDicItem(DicItemMapper dicItemMapper) {
        List<DicItem> dicItems = dicItemMapper.selectList(new QueryWrapper<>());
        for (DicItem dicItem : dicItems) {
            Integer dicTypeCode = dicItem.getDicTypeCode();
            Map<Integer, String> map = MAP.getOrDefault(dicTypeCode, new HashMap<>());
            map.put(dicItem.getDicItemCode(), dicItem.getDicItemName());
            MAP.put(dicTypeCode, map);
        }
    }

    public static boolean check(Integer dicTypeCode, Integer dicItemCode) {
        return MAP.get(dicTypeCode).containsKey(dicItemCode);
    }

    public static String getTypeName(Integer dicTypeCode, Integer dicItemCode) {
        return MAP.get(dicTypeCode).get(dicItemCode);
    }
}

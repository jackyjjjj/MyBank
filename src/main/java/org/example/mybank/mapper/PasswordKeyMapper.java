package org.example.mybank.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.mybank.entity.PasswordKey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Mr.J
* @description 针对表【PasswordKey】的数据库操作Mapper
* @createDate 2024-06-07 10:45:59
* @Entity org.example.mybank.entity.PasswordKey
*/
public interface PasswordKeyMapper extends BaseMapper<PasswordKey> {
    @Insert("insert into passwordKey(accountNumber, passwordKey) values (#{accountNumber}, #{passwordKey})")
    boolean setPasswordKey(String accountNumber,String passwordKey);


    @Select("select passwordKey from passwordkey where accountNumber = #{accountNumber}")
    String getPasswordKey(String accountNumber);
}





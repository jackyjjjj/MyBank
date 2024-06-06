package org.example.mybank.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.mybank.entity.AccountInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mybank.entity.paramObject.addAccount_param;

import java.util.List;

/**
 * @author Mr.J
 * @description 针对表【account_info】的数据库操作Mapper
 * @createDate 2024-06-05 22:48:36
 * @Entity org.example.mybank.entity.AccountInfo
 */
public interface AccountInfoMapper extends BaseMapper<AccountInfo> {
    @Select("SELECT * FROM account_info WHERE accountNumber = #{accountNumber}")
    List<AccountInfo> selectAllByAccountNumber(@Param("accountNumber") String accountNumber);

    @Insert("insert into account_info (accountType,accountNumber,balance,isValid,quota,staffId) values " +
            "(#{accountType}, #{accountNumber}, #{balance}, " +
            "#{isValid},#{quota},#{staffId}  )")
    boolean insertParam(addAccount_param accountParam);
}





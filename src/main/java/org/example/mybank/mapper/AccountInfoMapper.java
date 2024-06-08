package org.example.mybank.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.mybank.entity.AccountInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.addAccount_param;

import java.util.List;

/**
 * @author Mr.J
 * @description 针对表【account_info】的数据库操作Mapper
 * @createDate 2024-06-05 22:48:36
 * @Entity org.example.mybank.entity.AccountInfo
 */
public interface AccountInfoMapper extends BaseMapper<AccountInfo> {

    @Insert("insert into account_info (accountType,accountNumber,balance,isValid,quota,staffId,password,userId) values " +
            "(#{accountType}, #{accountNumber}, #{balance}, " +
            "#{isValid},#{quota},#{staffId},#{password},#{userId})")
    boolean insertParam(addAccount_param accountParam);

    @Update("UPDATE account_info SET isValid = 0 WHERE accountNumber = #{accountNumber}")
    boolean deleteAccountLogically(String accountNumber);

    @Select("select\n" +
            "    u.userName,\n" +
            "    a.accountNumber,\n" +
            "    a.balance,\n" +
            "    a.quota,\n" +
            "    a.isValid,\n" +
            "    a.accountType,\n" +
            "    a.createTime,\n" +
            "    u.phoneNumber AS phone,\n" +
            "    s.staffName\n" +
            "from account_info a\n" +
            "         left join user_info u on a.userId = u.userId\n" +
            "         left join staff s on a.staffId = s.staffId\n" +
            "where u.identityNumber = #{identityNumber}")
    List<accountView> selectByIdentityNumber(String identityNumber);

    @Select("select\n" +
            "    u.userName,\n" +
            "    a.accountNumber,\n" +
            "    a.balance,\n" +
            "    a.quota,\n" +
            "    a.isValid,\n" +
            "    a.accountType,\n" +
            "    a.createTime,\n" +
            "    u.phoneNumber AS phone,\n" +
            "    s.staffName,\n" +
            "    a.password\n" +
            "from account_info a\n" +
            "         left join user_info u on a.userId = u.userId\n" +
            "         left join staff s on a.staffId = s.staffId\n" +
            "where a.accountNumber = #{accountNumber}")
    accountView selectByAccountNumber(String accountNumber);

    @Select("select\n" +
            "    u.userName,\n" +
            "    a.accountNumber,\n" +
            "    a.balance,\n" +
            "    a.quota,\n" +
            "    a.isValid,\n" +
            "    a.accountType,\n" +
            "    a.createTime,\n" +
            "    u.phoneNumber AS phone,\n" +
            "    s.staffName,\n" +
            "    a.password\n" +
            "from account_info a\n" +
            "         left join user_info u on a.userId = u.userId\n" +
            "         left join staff s on a.staffId = s.staffId\n")
    List<accountView> selectAllAccount();


    @Select("select account_info.accountId from account_info where accountNumber = #{accountNumber}")
    String selectAccountIdByAccountNumber(String accountNumber);
}





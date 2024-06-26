package org.example.mybank.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
            "where u.identityNumber = #{identityNumber} and a.isValid = 1")
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
            "where a.accountNumber = #{accountNumber} and a.isValid = 1")
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
            "         left join staff s on a.staffId = s.staffId\n" +
            "where a.isValid=1")
    List<accountView> selectAllAccount();


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
            "where u.identityNumber = #{identityNumber} and a.isValid = 1")
    Page<accountView> selectByIdentityNumberPaging(Page<accountView> page, @Param("identityNumber") String identityNumber);

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
            "where a.isValid=1")
    Page<accountView> selectAllAccountPaging(Page<accountView> page);


    @Select("select account_info.accountId from account_info where accountNumber = #{accountNumber}")
    String selectAccountIdByAccountNumber(String accountNumber);


    @Update("update account_info set password = #{password} where accountNumber = #{accountNumber}")
    boolean updatePassword(String accountNumber, String password);

    @Update("update account_info set quota = #{quotaLevel} where accountNumber = #{accountNumber}")
    boolean updateQuotaLevel(String accountNumber, Integer quotaLevel);
}





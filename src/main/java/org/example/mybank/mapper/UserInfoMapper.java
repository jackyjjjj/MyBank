package org.example.mybank.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.mybank.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mybank.entity.myObject.UserView;
import org.example.mybank.entity.myObject.addUser_param;

/**
 * @author Mr.J
 * @description 针对表【user_info】的数据库操作Mapper
 * @createDate 2024-06-05 22:50:02
 * @Entity org.example.mybank.entity.UserInfo
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {


    @Select("select userId from user_info where identityNumber = #{identityNumber}")
    public String selectUserIdByIdentityNumber(String identityNumber);

    @Insert("insert into user_info(userName, gender, identityNumber, phoneNumber, email) " +
            "values(#{userName}, #{gender}, #{identityNumber}, #{phoneNumber}, #{email})")
    public boolean addUser(addUser_param param);

    @Update("UPDATE user_info SET isValid = 0 WHERE identityNumber = #{identityNumber}")
    boolean deleteUserLogically(String identityNumber);



//    select userName,gender,identityNumber,phoneNumber,email" +
//            "from user_info where indetityNumber = #{identityNumber}

    @Select("select userName,gender,identityNumber,phoneNumber,email from user_info where identityNumber = #{identityNumber}")
    public UserView selectUserInfoByIdentityNumber(String identityNumber);





}





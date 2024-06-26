package org.example.mybank.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.mybank.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Mr.J
* @description 针对表【staff】的数据库操作Mapper
* @createDate 2024-06-05 22:50:02
* @Entity org.example.mybank.entity.Staff
*/


public interface StaffMapper extends BaseMapper<Staff> {
    @Select("select * from staff where staffName = #{name} and password = #{password}")
    public boolean selectStaff(String name,String password);
}





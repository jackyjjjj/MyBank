package org.example.mybank.service;

import org.example.mybank.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Mr.J
* @description 针对表【staff】的数据库操作Service
* @createDate 2024-06-05 22:50:02
*/
public interface StaffService extends IService<Staff> {
    boolean selectStaff(String username, String password);
}

package org.example.mybank.service;

import org.example.mybank.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Mr.J
* @description 针对表【user_info】的数据库操作Service
* @createDate 2024-06-05 22:50:02
*/
public interface UserInfoService extends IService<UserInfo> {
    boolean verify_identityNumber(String identityNumber);
}

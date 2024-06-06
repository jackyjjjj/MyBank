package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mybank.entity.UserInfo;
import org.example.mybank.service.UserInfoService;
import org.example.mybank.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Mr.J
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2024-06-05 22:50:02
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}





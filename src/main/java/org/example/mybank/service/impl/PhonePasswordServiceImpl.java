package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mybank.entity.PhonePassword;
import org.example.mybank.service.PhonePasswordService;
import org.example.mybank.mapper.PhonePasswordMapper;
import org.springframework.stereotype.Service;

/**
* @author Mr.J
* @description 针对表【phone_password】的数据库操作Service实现
* @createDate 2024-06-05 22:50:01
*/
@Service
public class PhonePasswordServiceImpl extends ServiceImpl<PhonePasswordMapper, PhonePassword>
    implements PhonePasswordService{

}





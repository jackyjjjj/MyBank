package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.PasswordKey;
import org.example.mybank.entity.myObject.EncryptPassword;
import org.example.mybank.service.PasswordKeyService;
import org.example.mybank.mapper.PasswordKeyMapper;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
/**
* @author Mr.J
* @description 针对表【PasswordKey】的数据库操作Service实现
* @createDate 2024-06-07 10:45:59
*/
@Service
@RequiredArgsConstructor
public class PasswordKeyServiceImpl extends ServiceImpl<PasswordKeyMapper, PasswordKey>
    implements PasswordKeyService {


    @Override
    public String encryptPassword(String password,String key) throws Exception {
        return EncryptPassword.encrypt(password, EncryptPassword.stringToKey(key));
    }

    @Override
    public String decryptPassword(String password,String key) throws Exception {
        return EncryptPassword.decrypt(password, EncryptPassword.stringToKey(key));
    }
}





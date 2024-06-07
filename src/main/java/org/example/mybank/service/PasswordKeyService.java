package org.example.mybank.service;

import org.example.mybank.entity.PasswordKey;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Mr.J
* @description 针对表【PasswordKey】的数据库操作Service
* @createDate 2024-06-07 10:45:59
*/
public interface PasswordKeyService extends IService<PasswordKey> {
    String encryptPassword(String password,String key) throws Exception;

    String decryptPassword(String password,String key) throws Exception;

}

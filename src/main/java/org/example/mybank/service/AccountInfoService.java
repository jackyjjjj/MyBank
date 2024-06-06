package org.example.mybank.service;

import org.example.mybank.entity.AccountInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.mybank.entity.myObject.addAccount_param;

import java.math.BigDecimal;

/**
* @author Mr.J
* @description 针对表【account_info】的数据库操作Service
* @createDate 2024-06-05 22:48:37
*/
public interface AccountInfoService extends IService<AccountInfo> {


    boolean verify_accountNumber(String accountNumber);
    boolean verify_balance(BigDecimal balance);
    boolean verify_accountType(Integer type);
    boolean verify_accountStatus(Integer status);
    boolean verify_quota(Integer quota);


    boolean addAccount(addAccount_param accountParam);

    boolean closeAccount(String accountNumber);
}

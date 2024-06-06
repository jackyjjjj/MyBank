package org.example.mybank.service;

import org.example.mybank.entity.AccountInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Mr.J
* @description 针对表【account_info】的数据库操作Service
* @createDate 2024-06-05 22:48:37
*/
public interface AccountInfoService extends IService<AccountInfo> {

    boolean test(AccountInfo accountInfo);
}

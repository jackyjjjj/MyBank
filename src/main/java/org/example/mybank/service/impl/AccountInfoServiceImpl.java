package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.AccountInfo;
import org.example.mybank.service.AccountInfoService;
import org.example.mybank.mapper.AccountInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author Mr.J
 * @description 针对表【account_info】的数据库操作Service实现
 * @createDate 2024-06-05 22:48:36
 */
@Service
@RequiredArgsConstructor
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfo> implements AccountInfoService {
    final private AccountInfoMapper accountInfoMapper;


    @Override
    public boolean test(AccountInfo accountInfo) {
       // accountInfoMapper.insert(accountInfo);
        return false;
    }
}





package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.AccountInfo;
import org.example.mybank.entity.DicItem;
import org.example.mybank.entity.myObject.addAccount_param;
import org.example.mybank.mapper.DicItemMapper;
import org.example.mybank.service.AccountInfoService;
import org.example.mybank.mapper.AccountInfoMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Mr.J
 * @description 针对表【account_info】的数据库操作Service实现
 * @createDate 2024-06-05 22:48:36
 */
@Service
@RequiredArgsConstructor
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfo> implements AccountInfoService {
    final private AccountInfoMapper accountInfoMapper;
    final private DicItemMapper dicItemMapper;

    @Override
    public boolean verify_accountNumber(String accountNumber) {
        QueryWrapper<AccountInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accountNumber", accountNumber);

        return accountInfoMapper.exists(queryWrapper);
    }

    @Override
    public boolean verify_balance(BigDecimal balance) {
        return balance.compareTo(BigDecimal.ZERO) < 0;
    }

    @Override
    public boolean verify_accountType(Integer type) {
        QueryWrapper<DicItem> dicItemQueryWrapper = new QueryWrapper<>();
        dicItemQueryWrapper.eq("dicTypeCode", 2);
        dicItemQueryWrapper.eq("dicItemCode", type);

        return dicItemMapper.exists(dicItemQueryWrapper);
    }

    @Override
    public boolean verify_accountStatus(Integer status) {
        return status == 1;
    }

    @Override
    public boolean verify_quota(Integer quota) {
        QueryWrapper<DicItem> dicItemQueryWrapper = new QueryWrapper<>();
        dicItemQueryWrapper.eq("dicTypeCode", 5);
        dicItemQueryWrapper.eq("dicItemCode", quota);

        return dicItemMapper.exists(dicItemQueryWrapper);
    }

    @Override
    public boolean addAccount(addAccount_param accountParam) {
        //账号已经存在、余额小于0、account、quota类型不合法、设置的状态不为1 就返回false
        if (verify_accountNumber(accountParam.getAccountNumber()) ||
                verify_balance(accountParam.getBalance()) ||
                !verify_accountType(accountParam.getAccountType()) ||
                !verify_accountStatus(accountParam.getIsValid()) ||
                !verify_quota(accountParam.getQuota())) {
            return false;

        } else {
            accountInfoMapper.insertParam(accountParam);
            return true;
        }
    }

    @Override
    public boolean closeAccount(String accountNumber) {
        //逻辑删除
        accountInfoMapper.deleteAccountLogically(accountNumber);
        return true;
    }
}





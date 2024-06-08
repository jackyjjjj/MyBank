package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.AccountInfo;
import org.example.mybank.entity.myObject.EncryptPassword;
import org.example.mybank.entity.myObject.StaticDicItem;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.addAccount_param;
import org.example.mybank.mapper.DicItemMapper;
import org.example.mybank.mapper.UserInfoMapper;
import org.example.mybank.service.AccountInfoService;
import org.example.mybank.mapper.AccountInfoMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
    final private UserInfoMapper userInfoMapper;

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
        return StaticDicItem.check(2, type);
    }

    @Override
    public boolean verify_accountStatus(Integer status) {
        return status == 1;
    }

    @Override
    public boolean verify_quota(Integer quota) {
        return StaticDicItem.check(5, quota);
    }

    @Override
    public boolean verify_password(String accountNumber,String password){
        return true;
    }




    @Override
    public List<accountView> getAllAccountView(){
        List<accountView> list = accountInfoMapper.selectAllAccount();
        System.out.println(list.size());
        for (accountView account : list){
            fillAccountView(account,account.getQuota(),account.getAccountType(),account.getIsValid());
        }
        return list;
    }

    @Override
    public List<accountView> getAccountViewByIdentityNumber(String identityNumber){
        List<accountView> list = accountInfoMapper.selectByIdentityNumber(identityNumber);
        System.out.println(list.size());
        for (accountView account : list){
            fillAccountView(account,account.getQuota(),account.getAccountType(),account.getIsValid());
        }
        return list;
    }

    @Override
    public accountView getAccountViewByAccountNumber(String accountNumber){
        accountView account = accountInfoMapper.selectByAccountNumber(accountNumber);
        System.out.println(account.toString());
        fillAccountView(account,account.getQuota(),account.getAccountType(),account.getIsValid());

        return account;
    }



    @Override
    public void fillAccountView(accountView account,String quota,String accountType,String isValid){
        account.setQuota(StaticDicItem.getTypeName(5,Integer.valueOf(quota)));
        account.setAccountType(StaticDicItem.getTypeName(2,Integer.valueOf(accountType)));
        account.setIsValid(StaticDicItem.getTypeName(1,Integer.valueOf(isValid)));
    }

    @Override
    public boolean addAccount(addAccount_param accountParam) throws Exception {

        System.out.println(accountParam.toString());

        accountParam.setUserId(userInfoMapper.selectUserIdByIdentityNumber(accountParam.getUserId()));
        accountParam.setPassword(EncryptPassword.encrypt(accountParam.getPassword()));
        accountInfoMapper.insertParam(accountParam);
        return true;
    }


    @Override
    public boolean closeAccount(String accountNumber) {
        //逻辑删除
        accountInfoMapper.deleteAccountLogically(accountNumber);
        return true;
    }
}





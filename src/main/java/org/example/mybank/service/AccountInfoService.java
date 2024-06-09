package org.example.mybank.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mybank.entity.AccountInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.addAccount_param;

import java.math.BigDecimal;
import java.util.List;

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
    boolean verify_password(String accountNumber,String password);


    void fillAccountView(accountView accountView,String quota,String accountType,String isValid);
    boolean addAccount(addAccount_param accountParam) throws Exception;



    List<accountView> getAllAccountView();
    List<accountView> getAccountViewByIdentityNumber(String identityNumber);
    accountView getAccountViewByAccountNumber(String accountNumber);

    Page<accountView> selectByIdPaging(Page<accountView> page, String identityNumber);
    Page<accountView> getAllAccountViewPaging(Page<accountView> page);

    boolean closeAccount(String accountNumber);

    boolean updateQuotaLevel(String accountNumber,Integer quotaLevel);
    boolean updatePassword(String accountNumber,String password) throws Exception;
}

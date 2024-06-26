package org.example.mybank.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.JsonResult;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.addAccount_param;
import org.example.mybank.service.AccountInfoService;
import org.example.mybank.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {


    final private AccountInfoService accountInfoService;
    final private UserInfoService userInfoService;

    @PostMapping("/account/addAccount")
    public JsonResult addAccount(@RequestBody addAccount_param accountParam) throws Exception {
        if (accountInfoService.verify_accountNumber(accountParam.getAccountNumber())) {
            return new JsonResult(false, "账户号码已经存在");
        }
        if (accountInfoService.verify_balance(accountParam.getBalance())) {
            return new JsonResult(false, "账户余额不合法");
        }
        if (!accountInfoService.verify_accountType(accountParam.getAccountType())) {
            return new JsonResult(false, "账户类型不合法");
        }
        if (!accountInfoService.verify_quota(accountParam.getQuota())) {
            return new JsonResult(false, "账户额度类型不合法");
        }
        if (!accountInfoService.verify_accountStatus(accountParam.getIsValid())) {
            return new JsonResult(false, "账户状态不合法");
        }
        if(!userInfoService.verify_identityNumber(accountParam.getUserId())){
            return new JsonResult(false, "身份证号码不存在");
        }

        return new JsonResult(accountInfoService.addAccount(accountParam), "账户创建成功");
    }

    @PostMapping("/account/closeAccount")
    public JsonResult closeAccount(@RequestParam("accountNumber") String accountNumber) {
        if (!accountInfoService.verify_accountNumber(accountNumber)) {
            return new JsonResult(false, "账户号码不存在");
        } else {
            return new JsonResult(accountInfoService.closeAccount(accountNumber), "账户关闭成功");
        }
    }

    @PostMapping("/account/selectAccountByAccountNumber")
    public JsonResult selectAccountByAccountNumber(@RequestParam("accountNumber") String accountNumber) {
        // 验证账户号码是否存在
        if (!accountInfoService.verify_accountNumber(accountNumber)) {
            return new JsonResult(false, "账户号码不存在");
        }
        return new JsonResult(accountInfoService.getAccountViewByAccountNumber(accountNumber));
    }

    @PostMapping("/account/selectAccountById")
    public JsonResult selectAccountById(@RequestParam("identityNumber") String identityNumber) {

        if (!userInfoService.verify_identityNumber(identityNumber)) {
            return new JsonResult(false, "身份证号码不存在");
        }
        return new JsonResult(accountInfoService.getAccountViewByIdentityNumber(identityNumber));
    }

    @PostMapping("/account/selectAll")
    public JsonResult selectAll(){

        return new JsonResult(accountInfoService.getAllAccountView());
    }


    @PostMapping("/account/selectByIdPaging")
    public JsonResult selectByIdPaging(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = "4") Integer pageSize,
                                       @RequestParam(name = "searchWord", required=true) String searchWord){

        Page<accountView> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        return new JsonResult(accountInfoService.selectByIdPaging(page, searchWord));

    }

    @PostMapping("/account/selectAllAccountPaging")
    public JsonResult selectAllAccountPaging(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = "4") Integer pageSize){

        Page<accountView> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        return new JsonResult(accountInfoService.getAllAccountViewPaging(page));

    }


    @PostMapping("/account/changeQuota")
    public JsonResult changeQuota(@RequestParam("quota") Integer quotaLevel,
                                  @RequestParam("accountNumber") String accountNumber){

        if(!accountInfoService.verify_quota(quotaLevel)){
            return new JsonResult(false, "额度等级不合法");
        }
        return new JsonResult(accountInfoService.updateQuotaLevel(accountNumber,quotaLevel));
    }

    @PostMapping("/account/changePassword")
    public JsonResult changePassword(@RequestParam("password") String password,
                                     @RequestParam("accountNumber") String accountNumber) throws Exception {
        return new JsonResult(accountInfoService.updatePassword(accountNumber,password));
    }
}

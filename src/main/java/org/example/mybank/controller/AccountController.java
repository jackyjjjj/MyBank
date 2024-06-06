package org.example.mybank.controller;

import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.JsonResult;
import org.example.mybank.entity.myObject.addAccount_param;
import org.example.mybank.service.AccountInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {


    final private AccountInfoService accountInfoService;

    //    @GetMapping("/t")
//    public JsonResult test() {
//        AccountInfo val = new AccountInfo();
//        return new JsonResult(accountInfoService.test(val),"查找失败");
//    }
    @PostMapping("/account/addAccount")
    public JsonResult addAccount(@RequestBody addAccount_param accountParam) {
        if(accountInfoService.verify_accountNumber(accountParam.getAccountNumber())){
            return new JsonResult(false,"账户号码已经存在");
        }
        if(accountInfoService.verify_balance(accountParam.getBalance())){
            return new JsonResult(false,"账户余额不合法");
        }
        if(accountInfoService.verify_accountType(accountParam.getAccountType())){
            return new JsonResult(false,"账户类型不合法");
        }
        if(accountInfoService.verify_quota(accountParam.getQuota())){
            return new JsonResult(false,"账户额度类型不合法");
        }
        if(accountInfoService.verify_accountStatus(accountParam.getIsValid())){
            return new JsonResult(false,"账户状态不合法");
        }
        return new JsonResult(accountInfoService.addAccount(accountParam),"账户创建成功");
    }

    @PostMapping("/account/closeAccount")
    public JsonResult closeAccount(@RequestParam("accountNumber") String accountNumber) {
        if(!accountInfoService.verify_accountNumber(accountNumber)){
            return new JsonResult(false,"账户号码不存在");
        }else{
            return new JsonResult(accountInfoService.closeAccount(accountNumber),"账户关闭成功");
        }
    }

}

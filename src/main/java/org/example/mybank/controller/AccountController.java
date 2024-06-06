package org.example.mybank.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.example.mybank.entity.AccountInfo;
import org.example.mybank.entity.JsonResult;
import org.example.mybank.entity.paramObject.addAccount_param;
import org.example.mybank.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {


    final private AccountInfoService accountInfoService;

    //    @GetMapping("/t")
//    public JsonResult test() {
//        AccountInfo val = new AccountInfo();
//        return new JsonResult(accountInfoService.test(val),"查找失败");
//    }
    @PostMapping("/addAccount")
    public JsonResult addAccount(@RequestBody addAccount_param accountParam) {
        boolean bool = accountInfoService.addAccount(accountParam);
        if (!bool) {
            return new JsonResult(bool, "已经存在的账户号码");
        } else {
            return new JsonResult(bool, "添加成功");
        }
    }

}

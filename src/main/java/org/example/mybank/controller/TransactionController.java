package org.example.mybank.controller;


import jdk.security.jarsigner.JarSigner;
import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.JsonResult;
import org.example.mybank.entity.myObject.EncryptPassword;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.transaction_param;
import org.example.mybank.mapper.AccountInfoMapper;
import org.example.mybank.mapper.PasswordKeyMapper;
import org.example.mybank.service.TransactionRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    final private TransactionRecordService transactionRecordService;
    final private AccountInfoMapper accountInfoMapper;
    final private PasswordKeyMapper passwordKeyMapper;

    @PostMapping("/transaction/transfer")
    public JsonResult transfer(@RequestBody transaction_param param) throws Exception {
        accountView account = accountInfoMapper.selectByAccountNumber(param.getAccountNumber());
        accountView toAccount = accountInfoMapper.selectByAccountNumber(param.getToAccountNumber());
        if (Integer.parseInt(toAccount.getIsValid()) == 0) {
            return new JsonResult(false, "对方账户无效");
        }
        if(!param.getToAccountName().equals(toAccount.getUserName())){
            return new JsonResult(false, "对方账户名错误");
        }
        String key = passwordKeyMapper.getPasswordKey(param.getAccountNumber());
        if (!Objects.equals(param.getPassword(), EncryptPassword.decrypt(account.getPassword(), EncryptPassword.stringToKey(key)))) {
            System.out.println(EncryptPassword.decrypt(account.getPassword(), EncryptPassword.stringToKey(key)));
            System.out.println(param.getPassword());
            return new JsonResult(false, "密码错误");
        }
        if (!transactionRecordService.checkBalance(account, param.getAmount())) {
            return new JsonResult(false, "余额不足");
        }
        if (!transactionRecordService.checkQuota(account, param.getAmount())) {
            return new JsonResult(false, "转账金额大于单笔交易额度");
        }
        if (transactionRecordService.transfer(param)) {
            return new JsonResult(true, "转账成功");
        }
        return new JsonResult(false, "转账失败");
    }


}

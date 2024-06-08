package org.example.mybank.controller;


import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.JsonResult;
import org.example.mybank.entity.myObject.EncryptPassword;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.transaction_param;
import org.example.mybank.mapper.AccountInfoMapper;
import org.example.mybank.service.TransactionRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    final private TransactionRecordService transactionRecordService;
    final private AccountInfoMapper accountInfoMapper;


    @PostMapping("/transaction/transfer")
    public JsonResult transfer(@RequestBody transaction_param param) throws Exception {
        accountView account = accountInfoMapper.selectByAccountNumber(param.getAccountNumber());
        accountView toAccount = accountInfoMapper.selectByAccountNumber(param.getToAccountNumber());
        if (Integer.parseInt(toAccount.getIsValid()) == 0) {
            return new JsonResult(false, "对方账户无效");
        }
        if (!param.getToAccountName().equals(toAccount.getUserName())) {
            return new JsonResult(false, "对方账户名错误");
        }

        if (!param.getPassword().equals(EncryptPassword.decrypt(account.getPassword()))) {
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

    @PostMapping("/transaction/selectRecords")
    public JsonResult selectRecords(@RequestParam("dateBegin") String dateBegin,
                                    @RequestParam("dateEnd") String dateEnd,
                                    @RequestParam("accountNumber") String accountNumber) throws Exception {
        return new JsonResult(transactionRecordService.selectTransactionRecord(dateBegin, dateEnd, accountNumber));
    }
}

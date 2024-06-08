package org.example.mybank.service;

import org.example.mybank.entity.TransactionRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.transaction_param;

/**
* @author Mr.J
* @description 针对表【transaction_record】的数据库操作Service
* @createDate 2024-06-05 22:50:02
*/
public interface TransactionRecordService extends IService<TransactionRecord> {
    boolean transfer(transaction_param param);
    boolean checkBalance(accountView accountView, double amount);
    boolean checkQuota(accountView accountView, double amount);
}

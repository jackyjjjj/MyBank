package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.TransactionRecord;
import org.example.mybank.entity.myObject.StaticDicItem;
import org.example.mybank.entity.myObject.accountView;
import org.example.mybank.entity.myObject.transactionView;
import org.example.mybank.entity.myObject.transaction_param;
import org.example.mybank.mapper.AccountInfoMapper;
import org.example.mybank.service.TransactionRecordService;
import org.example.mybank.mapper.TransactionRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Mr.J
 * @description 针对表【transaction_record】的数据库操作Service实现
 * @createDate 2024-06-05 22:50:02
 */
@Service
@RequiredArgsConstructor
public class TransactionRecordServiceImpl extends ServiceImpl<TransactionRecordMapper, TransactionRecord>
        implements TransactionRecordService {

    final private TransactionRecordMapper transactionRecordMapper;
    private final AccountInfoMapper accountInfoMapper;


    @Override
    @Transactional
    public boolean transfer(transaction_param param) {
        String account1 = accountInfoMapper.selectAccountIdByAccountNumber(param.getAccountNumber());
        String account2 = accountInfoMapper.selectAccountIdByAccountNumber(param.getToAccountNumber());
        TransactionRecord transactionRecord = new TransactionRecord();

        transactionRecord.setAccountId(account1);
        transactionRecord.setTransactionType(1);
        transactionRecord.setTransactionAmount(BigDecimal.valueOf(param.getAmount()));
        transactionRecord.setTransferToAccountId(account2);
        return transactionRecordMapper.transfer(param.getAccountNumber(), param.getToAccountNumber(), param.getAmount()) &&
                transactionRecordMapper.insertTransactionRecord(transactionRecord);
    }

    @Override
    public boolean checkBalance(accountView accountView, double amount) {
        return Double.parseDouble(accountView.getBalance()) >= amount;
    }

    @Override
    public boolean checkQuota(accountView accountView, double amount) {
        double quota = Double.parseDouble(StaticDicItem.getTypeName(5, Integer.valueOf(accountView.getQuota())));
        return quota >= amount;
    }

    @Override
    public List<transactionView> selectTransactionRecord(String dateBegin, String dateEnd, String accountNumber) {
        String accountId = accountInfoMapper.selectAccountIdByAccountNumber(accountNumber);
        List<transactionView> list = transactionRecordMapper.selectTransactionRecord(dateBegin, dateEnd, accountId);
        for (transactionView transactionView : list) {
            transactionView.setTransactionType(StaticDicItem.getTypeName(4, Integer.valueOf(transactionView.getTransactionType())));
        }
        return list;
    }


}





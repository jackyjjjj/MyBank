package org.example.mybank.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.mybank.entity.TransactionRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mybank.entity.myObject.transactionView;

import java.util.List;

/**
 * @author Mr.J
 * @description 针对表【transaction_record】的数据库操作Mapper
 * @createDate 2024-06-05 22:50:02
 * @Entity org.example.mybank.entity.TransactionRecord
 */
public interface TransactionRecordMapper extends BaseMapper<TransactionRecord> {

    @Update("update account_info set balance = balance - #{amount} where accountNumber = #{accountNumber1};" +
            "update account_info set balance = balance + #{amount} where accountNumber = #{accountNumber2};")
    public boolean transfer(String accountNumber1, String accountNumber2, double amount);

    @Insert("insert into transaction_record(accountId,transactionType,transactionAmount,transferToAccountId) value " +
            "(#{accountId},#{transactionType},#{transactionAmount},#{transferToAccountId})")
    public boolean insertTransactionRecord(TransactionRecord transactionRecord);



    List<transactionView> selectTransactionRecord(String dateBegin,String dateEnd,String accountId);
}





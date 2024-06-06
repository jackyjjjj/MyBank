package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mybank.entity.TransactionRecord;
import org.example.mybank.service.TransactionRecordService;
import org.example.mybank.mapper.TransactionRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author Mr.J
* @description 针对表【transaction_record】的数据库操作Service实现
* @createDate 2024-06-05 22:50:02
*/
@Service
public class TransactionRecordServiceImpl extends ServiceImpl<TransactionRecordMapper, TransactionRecord>
    implements TransactionRecordService{

}





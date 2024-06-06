package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mybank.entity.RelationUserAccount;
import org.example.mybank.service.RelationUserAccountService;
import org.example.mybank.mapper.RelationUserAccountMapper;
import org.springframework.stereotype.Service;

/**
* @author Mr.J
* @description 针对表【relation_user_account】的数据库操作Service实现
* @createDate 2024-06-05 22:50:02
*/
@Service
public class RelationUserAccountServiceImpl extends ServiceImpl<RelationUserAccountMapper, RelationUserAccount>
    implements RelationUserAccountService{

}





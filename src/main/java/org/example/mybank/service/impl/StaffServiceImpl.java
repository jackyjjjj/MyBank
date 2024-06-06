package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mybank.entity.Staff;
import org.example.mybank.service.StaffService;
import org.example.mybank.mapper.StaffMapper;
import org.springframework.stereotype.Service;

/**
* @author Mr.J
* @description 针对表【staff】的数据库操作Service实现
* @createDate 2024-06-05 22:50:02
*/
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff>
    implements StaffService{

}





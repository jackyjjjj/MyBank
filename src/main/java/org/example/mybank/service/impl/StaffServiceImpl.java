package org.example.mybank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff>
        implements StaffService {


    final private StaffMapper staffMapper;
    @Override
    public boolean selectStaff(String name, String password) {
        return staffMapper.selectStaff(name, password);
    }


}





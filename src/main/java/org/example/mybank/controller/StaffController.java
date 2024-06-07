package org.example.mybank.controller;

import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.JsonResult;
import org.example.mybank.service.StaffService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.remote.JMXServerErrorException;

@RestController
@RequiredArgsConstructor
public class StaffController {

    final private StaffService staffService;

    @PostMapping("/staff/login")
    public JsonResult staffLogin(@RequestParam("staffName") String name,@RequestParam("password") String password) {
        //TODO 验证员工信息
        if (staffService.selectStaff(name, password)) {
            return new JsonResult(true, "登录成功");
        } else {
            return new JsonResult(false, "登录失败");
        }
    }
}

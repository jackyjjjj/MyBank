package org.example.mybank.controller;


import lombok.RequiredArgsConstructor;
import org.example.mybank.entity.JsonResult;
import org.example.mybank.entity.myObject.addAccount_param;
import org.example.mybank.entity.myObject.addUser_param;
import org.example.mybank.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    final private UserInfoService userInfoService;

    @PostMapping("/user/addUser")
    public JsonResult addUser(@RequestBody addUser_param param){
        if(userInfoService.verify_identityNumber(param.getIdentityNumber())){
            return new JsonResult(false,"用户已存在");
        }
        return new JsonResult(userInfoService.addUser(param),"添加成功");
    }

    @PostMapping("/user/delUser")
    public JsonResult delUser(@RequestParam("identityNumber") String identityNumber){
        if(!userInfoService.verify_identityNumber(identityNumber)){
            return new JsonResult(false,"用户不存在");
        }
        return new JsonResult(userInfoService.delUser(identityNumber),"删除成功");
    }

    @PostMapping("/user/show")
    public JsonResult show(@RequestParam("identityNumber") String identityNumber){
        return new JsonResult(userInfoService.show(identityNumber));
    }

}

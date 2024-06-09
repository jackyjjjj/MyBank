package org.example.mybank.entity.myObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class accountView {
    private String userName;
    private String accountNumber;
    private String accountType;
    private String balance;
    private String createTime;
    private String phone;
    private String quota;
    private String staffName;
    @JsonIgnore
    private String password;
    private String isValid;

}

package org.example.mybank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.mybank.mapper")
public class MyBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBankApplication.class, args);
    }

}

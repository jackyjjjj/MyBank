package org.example.mybank.entity.myObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class KeyHolder {
    private static final String KEY_FILE = "D:\\java\\project\\MyBank\\src\\main\\resources\\config.json";
    @Getter
    private static SecretKey secretKey;

    static {
        try {
            // 读取 JSON 文件内容
            String content = new String(Files.readAllBytes(Paths.get(KEY_FILE)));

            // 解析 JSON 字符串为 JSONObject
            JSONObject jsonObject = JSON.parseObject(content);

            // 获取密钥字符串
            String keyString = jsonObject.getString("key");

            // 将密钥字符串转换为 SecretKey 对象
            byte[] decodedKey = Base64.getDecoder().decode(keyString);
            secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load the secret key from " + KEY_FILE, e);
        }
    }

}

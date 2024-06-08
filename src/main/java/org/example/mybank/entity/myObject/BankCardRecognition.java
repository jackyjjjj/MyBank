package org.example.mybank.entity.myObject;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.BankCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.BankCardOCRResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;


public class BankCardRecognition {

    private String secretId = "AKID8UJBX0a8eDlKyY2a8oSMRhDkfijs2455";

    private String secretKey = "8Ke6fIuXF3xtlgnrvYPUYjzNk5UsIoLv";

    public String run(String url) {
        try {
            // 实例化一个认证对象，入参是腾讯云账户的 SecretId 和 SecretKey
            Credential cred = new Credential(secretId, secretKey);

            // 实例化一个http选项，可选，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");

            // 实例化一个client选项，可选，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            // 实例化要请求产品的client对象, clientProfile是可选的
            OcrClient client = new OcrClient(cred, "ap-guangzhou", clientProfile);

            // 实例化一个请求对象,每个接口都会对应一个request对象
            BankCardOCRRequest req = new BankCardOCRRequest();

            // 将本地图片文件转为Base64编码的字符串
            // 测试图片路径"D:\\idea\\student-project\\shixun-final3\\src\\test\\resources\\test2.jpg"
            File file = new File(url);
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            fis.read(buffer);
            fis.close();
            String imageBase64 = Base64.getEncoder().encodeToString(buffer);
            req.setImageBase64(imageBase64);

            // 返回的resp是一个BankCardOCRResponse的实例，与请求对象对应
            BankCardOCRResponse resp = client.BankCardOCR(req);
            // 输出JSON格式的字符串回包
            System.out.println(BankCardOCRResponse.toJsonString(resp));

            // 获取银行卡信息
            //System.out.println("银行卡号: " + resp.getCardNo());
            //System.out.println("银行卡类型: " + resp.getCardType());
            //System.out.println("银行卡有效期: " + resp.getValidDate());
            return resp.getCardNo();
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}

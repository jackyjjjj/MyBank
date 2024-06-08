package org.example.mybank.entity.myObject;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptPassword {

    public static String encrypt(String password) throws Exception {
        SecretKey key = KeyHolder.getSecretKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt the password using AES
    public static String decrypt(String encryptedPassword) throws Exception {
        SecretKey key = KeyHolder.getSecretKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted);
    }

    public static void main(String[] args) {
        try {
            // 待加密的密码
            String password = "mySecretPassword";

            // 加密
            String encryptedPassword = encrypt(password);
            System.out.println("Encrypted Password: " + encryptedPassword);

            // 解密
            String decryptedPassword = decrypt(encryptedPassword);
            System.out.println("Decrypted Password: " + decryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


// Generate a new AES key
//    public static SecretKey generateKey() throws Exception {
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//        keyGen.init(128); // for AES-128
//        return keyGen.generateKey();
//    }
//
//    // Encrypt the password using AES
//    public static String encrypt(String password, SecretKey key) throws Exception {
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encrypted = cipher.doFinal(password.getBytes());
//        return Base64.getEncoder().encodeToString(encrypted);
//    }
//
//    // Decrypt the password using AES
//    public static String decrypt(String encryptedPassword, SecretKey key) throws Exception {
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.DECRYPT_MODE, key);
//        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
//        byte[] decrypted = cipher.doFinal(decodedBytes);
//        return new String(decrypted);
//    }
//    // Convert SecretKey to String
//    public static String keyToString(SecretKey key) {
//        return Base64.getEncoder().encodeToString(key.getEncoded());
//    }
//
//    // Convert String to SecretKey
//    public static SecretKey stringToKey(String keyString) {
//        byte[] decodedKey = Base64.getDecoder().decode(keyString);
//        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//    }
//    public static void main(String[] args) {
//        try {
//            // Six-digit password
//            String password = "123456";
//
//            // Generate AES key
//            SecretKey key = generateKey();
//
//            // Print the secret key (for demonstration purposes, you should store this securely)
//            System.out.println("Secret Key: " + Base64.getEncoder().encodeToString(key.getEncoded()));
//
//            // Encrypt the password
//            String encryptedPassword = encrypt(password, key);
//            System.out.println("Encrypted Password: " + encryptedPassword);
//
//            // Decrypt the password
//            String decryptedPassword = decrypt(encryptedPassword, key);
//            System.out.println("Decrypted Password: " + decryptedPassword);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

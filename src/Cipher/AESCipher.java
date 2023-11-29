/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cipher;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Bum
 */
public class AESCipher {
        private static AESCipher instance = null;
    private static SecretKey key = null;

    private AESCipher(String kmsKey) {
        try {
            // Nếu key chưa được thiết lập từ KMS, thì thiết lập nó
            if (key == null && kmsKey != null) {
//                key = new SecretKeySpec(Base64.getDecoder().decode(kmsKey), "AES");
                    byte[] keyToBytes = "b2Z9965P97a7EC4B".getBytes(StandardCharsets.UTF_8);
                    key = new SecretKeySpec(keyToBytes,"AES");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AESCipher getInstance(String kmsKey) {
        if (instance == null) {
            instance = new AESCipher(kmsKey);
        }
        return instance;
    }

    public static AESCipher getInstance() {
        return getInstance(null);
    }

    public String encrypt(String data) throws Exception {
        if (key == null) {
            throw new IllegalStateException("Key has not been initialized. Call getInstance(String kmsKey) first.");
        }

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedData) throws Exception {
        if (key == null) {
            throw new IllegalStateException("Key has not been initialized. Call getInstance(String kmsKey) first.");
        }

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}

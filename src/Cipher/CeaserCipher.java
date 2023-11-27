/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cipher;

import java.util.Random;

/**
 *
 * @author Bum
 */
public class CeaserCipher {
    private int key;
    public CeaserCipher(int key) {
        this.key = key;
    }
    public static int generateRandomKey() {
        Random random = new Random();
        return random.nextInt(26); // Giả sử chỉ sử dụng 26 ký tự của bảng chữ cái tiếng Anh
    }
    
    public String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedText.append((char) ((c - base + key) % 26 + base));
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }
    private String encrypt(String text, int specificKey) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + specificKey + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
    public String decrypt(String ciphertext) {
        // Đối với mã Caesar, giải mã giống nhau với mã hóa với khóa âm
        return encrypt(ciphertext, -key);
    }
}

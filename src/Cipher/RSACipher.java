/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cipher;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import org.jfree.chart.renderer.category.StandardBarPainter;

/**
 *
 * @author Bum
 */
public class RSACipher {
    public static final int server_key_e = 7;
    
    public static final int server_key_n = 143;
   
    public static String encrypt(String message, int e, int n) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : message.toCharArray()) {
            int charValue = (int) character;
            int encryptedValue = modPow(charValue, e, n);
            encryptedText.append(encryptedValue).append(" ");
        }
        return encryptedText.toString().trim();
    }

    public static String decrypt(String encryptedMessage, int d, int n) {
        StringBuilder decryptedText = new StringBuilder();
        for (String value : encryptedMessage.split(" ")) {
            int encryptedValue = Integer.parseInt(value);
            int decryptedValue = modPow(encryptedValue, d, n);
            decryptedText.append((char) decryptedValue);
        }
        return decryptedText.toString();
    }
    private static int modPow(int base, int exponent, int modulus) {
        int result = 1;
        base %= modulus;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent /= 2;
            base = (base * base) % modulus;
        }

        return result;
    }
    
    public static void main(String[] args) {
        String res = "register";
        String encryptCode = RSACipher.encrypt(res, 7,143);
        System.out.println(encryptCode);
        String decryptCode = RSACipher.decrypt(encryptCode,103,143);
        System.out.println(decryptCode);
        
    }
}

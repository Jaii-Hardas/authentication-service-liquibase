package org.dnyanyog.encryption;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncDec {

  public static SecretKey generateAESKey() throws NoSuchAlgorithmException // key generation
      {
    KeyGenerator keyGenerator =
        KeyGenerator.getInstance("AES"); // create instance of keygenerator by static method

    keyGenerator.init(256); // assigning value to variable and use 256-bit size

    return keyGenerator.generateKey();
  }

  public static String encrypt(String plaintext, SecretKey key) throws Exception {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] plainTextByte = plaintext.getBytes(StandardCharsets.UTF_8);
    byte[] encryptedBytes = cipher.doFinal(plainTextByte);

    String encryptedDataString = Base64.getEncoder().encodeToString(encryptedBytes);
    return encryptedDataString;
  }

  public static String decrypt(String encryptedData, SecretKey key) throws Exception {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, key);

    byte[] encryptedByteArrayData = Base64.getDecoder().decode(encryptedData);
    byte[] decryptedBytes = cipher.doFinal(encryptedByteArrayData);

    return new String(decryptedBytes, StandardCharsets.UTF_8);
  }

  public static void main(String[] args) throws Exception {

    SecretKey key = generateAESKey();

    String plaintext = "Anuja";

    String encryptedText = encrypt(plaintext, key);
    System.out.println("Encypted Data:" + encryptedText);

    String decryptedText = decrypt(encryptedText, key);
    System.out.println("\nDecrypted Data:" + decryptedText);
  }
}

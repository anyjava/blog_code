package net.anyjava.blogcode.ecrypt;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

@Component
public class PasswordEncryptor {
    private final String key = "1234567890123456";
    private final String iv = key.substring(0, 16); // 16byte

    // AES 암호화
    EncryptPassword encrypt(PlainPassword data) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

            byte[] encrypted = cipher.doFinal(data.getPassword().getBytes("UTF-8"));
            return EncryptPassword.of(Base64.getEncoder().encodeToString(encrypted));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // AES 복호화
    PlainPassword decrypt(EncryptPassword encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData.getPassword());
            byte[] decrypted = cipher.doFinal(decodedBytes);
            return PlainPassword.of(new String(decrypted));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

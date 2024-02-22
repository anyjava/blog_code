package net.anyjava.blogcode.ecrypt;

import org.springframework.stereotype.Service;

@Service
public class PasswordEncryptionService {
    private final CardNumberEncryptor cardNumberEncryptor;

    public PasswordEncryptionService(CardNumberEncryptor cardNumberEncryptor) {
        this.cardNumberEncryptor = cardNumberEncryptor;
    }

    public EncryptCardNumber encryptPassword(PlainCardNumber password) {
        // 단순하게 구현함.
        return cardNumberEncryptor.encrypt(password);
    }

    public PlainCardNumber decryptPassword(EncryptCardNumber password) {
        // 단순하게 구현함.
        return cardNumberEncryptor.decrypt(password);
    }
}

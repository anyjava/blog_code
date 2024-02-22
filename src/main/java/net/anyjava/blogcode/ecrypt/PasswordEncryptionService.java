package net.anyjava.blogcode.ecrypt;

import org.springframework.stereotype.Service;

@Service
public class PasswordEncryptionService {
    private final PasswordEncryptor passwordEncryptor;

    public PasswordEncryptionService(PasswordEncryptor passwordEncryptor) {
        this.passwordEncryptor = passwordEncryptor;
    }

    public EncryptPassword encryptPassword(PlainPassword password) {
        // 단순하게 구현함.
        return passwordEncryptor.encrypt(password);
    }

    public PlainPassword decryptPassword(EncryptPassword password) {
        // 단순하게 구현함.
        return passwordEncryptor.decrypt(password);
    }
}

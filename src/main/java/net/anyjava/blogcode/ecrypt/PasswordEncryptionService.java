package net.anyjava.blogcode.ecrypt;

public class PasswordEncryptionService {
    EncryptPassword encryptPassword(DecryptPassword password) {
        // 단순하게 구현함.
        return new EncryptPassword("encrypted:" + password.getPassword());
    }

    DecryptPassword decryptPassword(EncryptPassword password) {
        // 단순하게 구현함.
        return new DecryptPassword(password.getPassword().replace("encrypted:", ""));
    }
}

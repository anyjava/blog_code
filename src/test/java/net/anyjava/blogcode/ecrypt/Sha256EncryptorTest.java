package net.anyjava.blogcode.ecrypt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Sha256EncryptorTest {

    @DisplayName("패스워드를 암호화 할 수 있다.")
    @Test()
    void encryptPassword() throws Exception {
        var sut = new PasswordEncryptor();
        var result = sut.encrypt(PlainPassword.of("test"));

        assertThat(result.getPassword()).isEqualTo("WkaOhqSK03Z1pSuPOdc03w==");
    }

    @DisplayName("암호화된 패스워드를 복호화 할 수 있다.")
    @Test()
    void decryptPassword() throws Exception {
        var sut = new PasswordEncryptor();
        var result = sut.decrypt(EncryptPassword.of("WkaOhqSK03Z1pSuPOdc03w=="));

        assertThat(result.getPassword()).isEqualTo("test");
    }
}

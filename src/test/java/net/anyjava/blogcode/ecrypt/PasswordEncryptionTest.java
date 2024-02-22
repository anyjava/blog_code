package net.anyjava.blogcode.ecrypt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordEncryptionTest {
    PasswordEncryptionService sut;

    @BeforeEach
    void setUp() {
        sut = new PasswordEncryptionService(new CardNumberEncryptor());
    }

    @Test
    @DisplayName("패스워드를 암호화 할 수 있다.")
    void encryptPassword() {
        var result = sut.encryptPassword(PlainCardNumber.of("test"));

        assertThat(result).isEqualTo(EncryptCardNumber.of("WkaOhqSK03Z1pSuPOdc03w=="));
    }

    @Test
    @DisplayName("암호화된 패스워드를 복호화 할 수 있다.")
    void decryptPassword() {
        var result = sut.decryptPassword(EncryptCardNumber.of("WkaOhqSK03Z1pSuPOdc03w=="));

        assertThat(result).isEqualTo(PlainCardNumber.of("test"));
    }
}

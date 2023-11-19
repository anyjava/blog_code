package net.anyjava.blogcode.ecrypt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordEncryptionTest {
    PasswordEncryptionService sut;

    @BeforeEach
    void setUp() {
        sut = new PasswordEncryptionService();
    }

    @Test
    @DisplayName("패스워드를 암호화 할 수 있다.")
    void encryptPassword() {
        var result = sut.encryptPassword(new DecryptPassword("test"));

        assertThat(result).isEqualTo(new EncryptPassword("encrypted:test"));
    }

    @Test
    @DisplayName("암호화된 패스워드를 복호화 할 수 있다.")
    void decryptPassword() {
        var result = sut.decryptPassword(new EncryptPassword("encrypted:test"));

        assertThat(result).isEqualTo(new DecryptPassword("test"));
    }
}

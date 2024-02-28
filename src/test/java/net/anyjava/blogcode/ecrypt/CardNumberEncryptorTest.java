package net.anyjava.blogcode.ecrypt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardNumberEncryptorTest {

    @DisplayName("카드번호를 암호화 할 수 있다.")
    @Test()
    void encryptCardNumber() throws Exception {
        var sut = new CardNumberEncryptor();
        var result = sut.encrypt(PlainCardNumber.of("test"));

        assertThat(result.getCardNumber()).isEqualTo("WkaOhqSK03Z1pSuPOdc03w==");
    }

    @DisplayName("암호화된 카드번호를 복호화 할 수 있다.")
    @Test()
    void decryptCardNumber() throws Exception {
        var sut = new CardNumberEncryptor();
        var result = sut.decrypt(EncryptCardNumber.of("WkaOhqSK03Z1pSuPOdc03w=="));

        assertThat(result.getCardNumber()).isEqualTo("test");
    }
}

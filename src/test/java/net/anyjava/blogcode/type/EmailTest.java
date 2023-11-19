package net.anyjava.blogcode.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    @DisplayName("이메일 포멧을 지키면 정상 생성")
    void ofNormal() {
        String email = "test@test.com";

        Email emailObj = Email.of(email);

        assertEquals(email, emailObj.getValue());
    }

    @Test
    @DisplayName("이메일 포멧이 아니라면 IllegalArgumentException 발생")
    void ofExceptionCase() {
        String email = "sample@sample";

        assertThrows(IllegalArgumentException.class, () -> {
            Email.of(email);
        });
    }
}

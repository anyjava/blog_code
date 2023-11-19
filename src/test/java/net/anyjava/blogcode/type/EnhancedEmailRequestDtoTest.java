package net.anyjava.blogcode.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnhancedEmailRequestDtoTest {

    @Test
    @DisplayName("이메일 포멧이 아니라면 IllegalArgumentException 발생")
    void of() {
        String email = "sample@sample";

        assertThrows(IllegalArgumentException.class, () -> {
            EnhancedEmailRequestDto.of(email);
        });
    }
}

package net.anyjava.blogcode.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EnhancedEmailRequestDtoTest {

    @Test
    @DisplayName("이메일 포멧과 날짜 포멧을 지키면 정상 생성")
    void of1() {
        String email = "test@sample.com";
        String regDate = "2013-11-17";

        EnhancedEmailRequestDto dto = EnhancedEmailRequestDto.of(email, regDate);

        assertThat(dto.getEmail()).isEqualTo(email);
        assertThat(dto.getRegDate().toString()).isEqualTo("2013-11-17");
    }

    @Test
    @DisplayName("이메일 포멧이 아니라면 IllegalArgumentException 발생")
    void of() {
        String email = "sample@sample";

        assertThrows(IllegalArgumentException.class, () -> {
            EnhancedEmailRequestDto.of(email, "2013-11-17");
        });
    }

    @Test
    @DisplayName("날짜 포멧을 지키지 않으면 DateTimeParseException 발생")
    void of2() {
        String email = "sample@sample.com";
        String regDate = "2013-11-17 00:00:00";

        assertThrows(DateTimeParseException.class, () -> {
            EnhancedEmailRequestDto.of(email, regDate);
        });
    }
}

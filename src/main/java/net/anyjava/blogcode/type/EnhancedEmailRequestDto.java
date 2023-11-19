package net.anyjava.blogcode.type;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class EnhancedEmailRequestDto {
    private final static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final static Pattern pattern = Pattern.compile(emailRegex);
    private final String email;
    // private final Email email; <- 직접 정의한 Type 을 사용하면, email 포멧에 대한 부분을 재사용 사능해진다.
    private final LocalDate regDate;

    private EnhancedEmailRequestDto(String email, LocalDate regDate) {
        this.email = email;
        this.regDate = regDate;
    }

    public static EnhancedEmailRequestDto of(String email, String regDate) {
        // email format 정규식으로 체크
        if (email == null || !pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("email is invalid");
        }
        final var date = LocalDate.parse(regDate);
        return new EnhancedEmailRequestDto(email, date);
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }
}

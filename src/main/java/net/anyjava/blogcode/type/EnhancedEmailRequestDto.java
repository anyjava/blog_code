package net.anyjava.blogcode.type;

import java.util.regex.Pattern;

public class EnhancedEmailRequestDto {
    private final static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final static Pattern pattern = Pattern.compile(emailRegex);
    private final String email;

    private EnhancedEmailRequestDto(String email) {
        this.email = email;
    }

    public static EnhancedEmailRequestDto of(String email) {
        // email format 정규식으로 체크
        if (email == null || !pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("email is invalid");
        }
        return new EnhancedEmailRequestDto(email);
    }
}

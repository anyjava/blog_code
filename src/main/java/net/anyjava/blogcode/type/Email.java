package net.anyjava.blogcode.type;

import java.util.regex.Pattern;

public class Email {
    private final static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final static Pattern pattern = Pattern.compile(emailRegex);
    private final String value;

    private Email(String value) {
        if (value == null || !pattern.matcher(value).matches()) {
            throw new IllegalArgumentException("email is invalid");
        }
        this.value = value;
    }

    public static Email of(String value) {
        return new Email(value);
    }

    public String getValue() {
        return value;
    }
}

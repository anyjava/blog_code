package net.anyjava.blogcode.type;

public class EmailRequsetDto {
    private final String email;
    private final String regDate;

    public EmailRequsetDto(String email, String regDate) {
        this.email = email;
        this.regDate = regDate;
    }

    public String getEmail() {
        return email;
    }

    public String getRegDate() {
        return regDate;
    }
}

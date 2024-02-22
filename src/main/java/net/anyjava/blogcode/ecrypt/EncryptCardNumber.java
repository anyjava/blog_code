package net.anyjava.blogcode.ecrypt;

import java.util.Objects;

public class EncryptCardNumber {
    private final String password;

    EncryptCardNumber(String password) {
        this.password = password;
    }

    public static EncryptCardNumber of(String password) {
        return new EncryptCardNumber(password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncryptCardNumber that)) return false;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return "EncryptPassword{" +
                "password='" + password + '\'' +
                '}';
    }
}

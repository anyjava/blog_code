package net.anyjava.blogcode.ecrypt;

import java.util.Objects;

public class EncryptPassword {
    private final String password;

    EncryptPassword(String password) {
        this.password = password;
    }

    public static EncryptPassword of(String password) {
        return new EncryptPassword(password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncryptPassword that)) return false;
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

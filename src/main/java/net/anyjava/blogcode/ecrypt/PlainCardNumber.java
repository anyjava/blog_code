package net.anyjava.blogcode.ecrypt;

import java.util.Objects;

public class PlainCardNumber {
    private final String password;

    PlainCardNumber(String password) {
        this.password = password;
    }

    public static PlainCardNumber of(String password) {
        return new PlainCardNumber(password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainCardNumber that)) return false;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}

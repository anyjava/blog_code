package net.anyjava.blogcode.ecrypt;

import java.util.Objects;

public class PlainPassword {
    private final String password;

    PlainPassword(String password) {
        this.password = password;
    }

    public static PlainPassword of(String password) {
        return new PlainPassword(password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainPassword that)) return false;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}

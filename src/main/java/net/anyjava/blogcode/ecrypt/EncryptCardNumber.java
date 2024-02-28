package net.anyjava.blogcode.ecrypt;

import java.util.Objects;

public class EncryptCardNumber {
    private final String cardNumber;

    EncryptCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static EncryptCardNumber of(String password) {
        return new EncryptCardNumber(password);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncryptCardNumber that)) return false;
        return Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    @Override
    public String toString() {
        return "EncryptPassword{" +
                "password='" + cardNumber + '\'' +
                '}';
    }
}

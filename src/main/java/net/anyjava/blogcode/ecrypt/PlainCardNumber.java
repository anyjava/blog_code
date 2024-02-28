package net.anyjava.blogcode.ecrypt;

import java.util.Objects;

public class PlainCardNumber {
    private final String cardNumber;

    PlainCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static PlainCardNumber of(String password) {
        return new PlainCardNumber(password);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainCardNumber that)) return false;
        return Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }
}

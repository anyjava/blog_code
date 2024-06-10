package net.anyjava.blogcode.poeaa.chapter09;

import java.util.Objects;
import java.util.stream.Stream;

public class Money {
    private long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public static Money dollars(Long amount) {
        return new Money(amount);
    }


    public Money add(Money amount) {
        return new Money(this.amount + amount.amount);
    }

    public Money[] allocate(int i) {
        return Stream.generate(() -> new Money(this.amount / i))
                .limit(i)
                .toArray(Money[]::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}

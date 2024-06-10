package net.anyjava.blogcode.poeaa.chapter09;

public class RevenueRecognition {
    private final Money amount;
    private final MfDate date;

    public RevenueRecognition(Money amount, MfDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Money getAmount() {
        return amount;
    }

    boolean isRecognizableBy(MfDate asOf) {
        return asOf.after(date) || asOf.equals(date);
    }
}

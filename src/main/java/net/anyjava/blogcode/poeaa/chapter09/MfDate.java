package net.anyjava.blogcode.poeaa.chapter09;

import java.time.LocalDate;

public class MfDate {
    private final LocalDate date;

    public MfDate(LocalDate date) {
        this.date = date;
    }

    public boolean after(MfDate date) {
        return this.date.isAfter(date.date);
    }

    public MfDate addDays(int firstRecognitionOffset) {
        return new MfDate(date.plusDays(firstRecognitionOffset));
    }
}

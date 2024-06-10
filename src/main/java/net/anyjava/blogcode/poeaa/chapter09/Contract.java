package net.anyjava.blogcode.poeaa.chapter09;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    private final List<RevenueRecognition> revenueRecognitions = new ArrayList<>();
    private Product product;
    private Money revenue;
    private MfDate whenSigned;
    private Long id;


    public Contract(Product product, Money revenue, MfDate whenSigned) {
        this.product = product;
        this.revenue = revenue;
        this.whenSigned = whenSigned;
    }

    public Money recognizedRevenue(MfDate asOf) {
        Money result = Money.dollars(0L);
        for (RevenueRecognition each : revenueRecognitions) {
            if (each.isRecognizableBy(asOf)) {
                result = result.add(each.getAmount());
            }
        }
        return result;
    }

    public void addRevenueRecognition(RevenueRecognition revenueRecognition) {
        this.revenueRecognitions.add(revenueRecognition);
    }

    public Money getRevenue() {
        return this.revenue;
    }

    public MfDate getWhenSigned() {
        return this.whenSigned;
    }
}

package net.anyjava.blogcode.poeaa.chapter09;

import net.anyjava.blogcode.poeaa.chapter09.service_layer.DbHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private final List<RevenueRecognition> revenueRecognitions = new ArrayList<>();
    private Product product;
    private Money revenue;
    private MfDate whenSigned;
    private Long id;
    private final String administratorEmailAddress = "test@gmail.com";

    public Contract(Product product, Money revenue, MfDate whenSigned) {
        this.product = product;
        this.revenue = revenue;
        this.whenSigned = whenSigned;
    }

    public static Contract readForUpdate(long contractNumber) {
        return DbHelper.load(contractNumber);
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

    public void calculateRecognitions() {
        product.calculateRevenueRecognitions(this);
    }

    public String getAdministratorEmailAddress() {
        return administratorEmailAddress;
    }
}

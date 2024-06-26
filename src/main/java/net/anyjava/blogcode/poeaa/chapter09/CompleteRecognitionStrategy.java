package net.anyjava.blogcode.poeaa.chapter09;

public class CompleteRecognitionStrategy implements RecognitionStrategy {
    @Override
    public void calculateRevenueRecognitions(Contract contract) {
        contract.addRevenueRecognition(new RevenueRecognition(contract.getRevenue(), contract.getWhenSigned()));
    }
}

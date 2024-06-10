package net.anyjava.blogcode.poeaa.chapter09;

public class ThreeWayRecognitionStrategy implements RecognitionStrategy {
    private final int firstRecognitionOffset;
    private final int secondRecognitionOffset;

    public ThreeWayRecognitionStrategy(int firstFRecognitionOffset, int secondRecognitionOffset) {
        this.firstRecognitionOffset = firstFRecognitionOffset;
        this.secondRecognitionOffset = secondRecognitionOffset;
    }

    @Override
    public void calculateRevenueRecognitions(Contract contract) {
        Money[] allocation = contract.getRevenue().allocate(3);
        contract.addRevenueRecognition(new RevenueRecognition(allocation[0], contract.getWhenSigned()));
        contract.addRevenueRecognition(new RevenueRecognition(allocation[1], contract.getWhenSigned().addDays(firstRecognitionOffset)));
        contract.addRevenueRecognition(new RevenueRecognition(allocation[2], contract.getWhenSigned().addDays(secondRecognitionOffset)));
    }
}

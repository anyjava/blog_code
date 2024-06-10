package net.anyjava.blogcode.poeaa.chapter09;

public class Product {
    private final String name;
    private final RecognitionStrategy recognitionStrategy;

    public Product(String name, RecognitionStrategy recognitionStrategy) {
        this.name = name;
        this.recognitionStrategy = recognitionStrategy;
    }

    public static Product newWordProcessor(String name) {
        return new Product(name, new CompleteRecognitionStrategy());
    }

    public static Product newSpreadsheet(String name) {
        return new Product(name, new ThreeWayRecognitionStrategy(60, 90));
    }

    public static Product newDatabase(String name) {
        return new Product(name, new ThreeWayRecognitionStrategy(30, 60));
    }

    public String getName() {
        return this.name;
    }

    public RecognitionStrategy getRecognitionStrategy() {
        return recognitionStrategy;
    }

    public void calculateRevenueRecognitions(Contract contract) {
        this.getRecognitionStrategy().calculateRevenueRecognitions(contract);
    }
}

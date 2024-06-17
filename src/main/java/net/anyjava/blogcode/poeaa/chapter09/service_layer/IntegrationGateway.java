package net.anyjava.blogcode.poeaa.chapter09.service_layer;

import net.anyjava.blogcode.poeaa.chapter09.Contract;

public interface IntegrationGateway {
    void publishRevenueRecognitionCalculation(Contract contract);
}

class IntegrationGatewayStub implements IntegrationGateway {
    public void publishRevenueRecognitionCalculation(Contract contract) {
        System.out.println("IntegrationGatewayStub: publishRevenueRecognitionCalculation");
    }
}

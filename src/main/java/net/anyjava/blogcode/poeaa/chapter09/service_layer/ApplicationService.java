package net.anyjava.blogcode.poeaa.chapter09.service_layer;

public class ApplicationService {
    protected EmailGateway getEmailGateway() {
        return new EmailGatewayStub();
    }

    protected IntegrationGateway getIntegrationGateway() {
        return new IntegrationGatewayStub();
    }
}

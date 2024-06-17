package net.anyjava.blogcode.poeaa.chapter09.service_layer;

public interface EmailGateway {
    void sendEmailMessage(String address, String subject, String body);
}

class EmailGatewayStub implements EmailGateway {
    public void sendEmailMessage(String address, String subject, String body) {
        System.out.println("To: " + address);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}

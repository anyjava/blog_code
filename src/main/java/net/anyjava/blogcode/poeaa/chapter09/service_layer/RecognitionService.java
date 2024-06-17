package net.anyjava.blogcode.poeaa.chapter09.service_layer;

import net.anyjava.blogcode.poeaa.chapter09.Contract;
import net.anyjava.blogcode.poeaa.chapter09.MfDate;
import net.anyjava.blogcode.poeaa.chapter09.Money;

public class RecognitionService extends ApplicationService {
    public void calculateRevenueRecognitions(long contractNumber) {
        Contract contract = Contract.readForUpdate(contractNumber);
        contract.calculateRecognitions();
        getEmailGateway().sendEmailMessage(
                contract.getAdministratorEmailAddress(),
                "RE: Contract #" + contractNumber,
                contract + " has had revenue recognitions calculated.");
        getIntegrationGateway().publishRevenueRecognitionCalculation(contract);
    }

    public Money recognizedRevenue(long contractNumber, MfDate asOf) {
        Contract contract = Contract.readForUpdate(contractNumber);
        return contract.recognizedRevenue(asOf);
    }
}

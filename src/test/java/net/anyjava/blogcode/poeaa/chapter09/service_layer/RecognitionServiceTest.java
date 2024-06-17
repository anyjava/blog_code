package net.anyjava.blogcode.poeaa.chapter09.service_layer;

import net.anyjava.blogcode.poeaa.chapter09.MfDate;
import net.anyjava.blogcode.poeaa.chapter09.Money;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class RecognitionServiceTest {

    @Test
    void testCalculateRevenueRecognitions() {
        RecognitionService recognitionService = new RecognitionService();
        recognitionService.calculateRevenueRecognitions(1L);

        var result = recognitionService.recognizedRevenue(1L, new MfDate(LocalDate.now().plusDays(30)));

        assertThat(result).isEqualTo(new Money(100_000L));
    }
}

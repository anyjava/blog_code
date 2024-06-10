package net.anyjava.blogcode.poeaa.chapter09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {
    @Test
    void testWordProcessor() {
        Product product = Product.newWordProcessor("wp");
        Contract contract = new Contract(
            product,
            Money.dollars(100_000L),
            new MfDate(LocalDate.of(2021, 1, 1))
        );
        product.calculateRevenueRecognitions(contract);

        assertThat("wp").isEqualTo(product.getName());
        assertThat(contract.getRevenue()).isEqualTo(Money.dollars(100_000L));
    }

    @Test
    void testSpreadsheet() {
        Product product = Product.newSpreadsheet("ss");
        Contract contract = new Contract(
            product,
            Money.dollars(100_000L),
            new MfDate(LocalDate.of(2021, 1, 1))
        );
        product.calculateRevenueRecognitions(contract);

        assertThat("ss").isEqualTo(product.getName());
        assertThat(contract.getRevenue()).isEqualTo(Money.dollars(100_000L));
        assertThat(contract.recognizedRevenue(new MfDate(LocalDate.of(2021, 1, 2)))).isEqualTo(Money.dollars(33_333L));
        assertThat(contract.recognizedRevenue(new MfDate(LocalDate.of(2021, 2, 2)))).isEqualTo(Money.dollars(33_333L));
        assertThat(contract.recognizedRevenue(new MfDate(LocalDate.of(2021, 3, 2)))).isEqualTo(Money.dollars(33_333L));
    }
}

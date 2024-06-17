package net.anyjava.blogcode.poeaa.chapter09.service_layer;

import net.anyjava.blogcode.poeaa.chapter09.Contract;
import net.anyjava.blogcode.poeaa.chapter09.MfDate;
import net.anyjava.blogcode.poeaa.chapter09.Money;
import net.anyjava.blogcode.poeaa.chapter09.Product;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

// NOTE: 영속성 지원을 위한 class
public class DbHelper {
    private static Map<Long, Contract> contracts = new HashMap<Long, Contract>();

    static {
        Product product = Product.newWordProcessor("wp");
        contracts.put(1L, new Contract(
                product,
                Money.dollars(100_000L),
                new MfDate(LocalDate.now())
        ));
    }

    public static Contract load(long contractNumber) {
        return contracts.get(contractNumber);
    }
}

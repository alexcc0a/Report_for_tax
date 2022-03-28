package ru.netology;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TaxService taxService = new TaxService();
        Supermarket supermarket1 = new Supermarket(taxService, 5);
        Supermarket supermarket2 = new Supermarket(taxService, 5);
        Supermarket supermarket3 = new Supermarket(taxService, 5);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.submit(supermarket1);
        service.submit(supermarket2);
        service.submit(supermarket3);
        service.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("Общая выручка: " + taxService.getAdder().sum());
        service.shutdown();
    }
}

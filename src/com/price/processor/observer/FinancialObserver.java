package com.price.processor.observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Пример реализации класса-наблюдателя
 */
public class FinancialObserver implements Observer, Display {
    Map<String, Double> currencyRates;

    public FinancialObserver() {
        currencyRates = new ConcurrentHashMap<>();
    }
    /**
     * Кладем новое значение конкретной валютной пары в структуру данных, предназначенную для работы
     * в условиях многопоточности. Обеспечиваем актуальность данных.
     */
    @Override
    public void update(String ccyPair, double rate) {
        currencyRates.put(ccyPair, rate);
        display(ccyPair);
    }
    /**
     * Отображение котировок. В примере происходит то быстро, то медленно для демонстрации.
     * В любом случае берем последнее значение по ключу из ConcurrentHashMap.
     */
    @Override
    public void display(String ccyPair) {
        try {
            Thread.sleep((long) Math.random() * (1 - 100000));
            System.out.println(currencyRates.get(ccyPair));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

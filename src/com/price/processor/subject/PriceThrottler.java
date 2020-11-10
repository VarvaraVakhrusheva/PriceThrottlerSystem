package com.price.processor.subject;

import com.price.processor.observer.Observer;
import java.util.ArrayList;

public class PriceThrottler implements PriceProcessor {
    private ArrayList<Observer> observers;

    public PriceThrottler() {
        observers = new ArrayList<>();
    }

    @Override
    public void onPrice(String ccyPair, double rate) {
        for (Observer o : observers) {
            o.update(ccyPair, rate);
        }
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }
}

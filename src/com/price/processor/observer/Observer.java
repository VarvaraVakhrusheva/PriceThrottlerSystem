package com.price.processor.observer;

public interface Observer {
    void update(String ccyPair, double rate);
}

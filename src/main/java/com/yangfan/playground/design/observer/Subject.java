package com.yangfan.playground.design.observer;

/**
 * 被观察者
 */
public interface Subject {
    void registerObserver(Observer observer, String message);
    void removeObserver(Observer observer, String message);
    void notifyObservers(String message);
}

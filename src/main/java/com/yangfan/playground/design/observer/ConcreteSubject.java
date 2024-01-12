package com.yangfan.playground.design.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    volatile List<Observer> observerList;

    @Override
    public void registerObserver(Observer observer, String message) {
        if(observerList == null) {
            synchronized (this) {
                if(observerList == null) {
                    observerList = new ArrayList<>();
                }
            }
        }
        observerList.add(observer);
        System.out.printf("驷马少女被[%s]捆住了!\n", message);
    }

    @Override
    public void removeObserver(Observer observer, String message) {
        if(observerList == null || observerList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        observerList.remove(observer);
        System.out.printf("驷马少女挣脱了[%s]的束缚。\n", message);
    }

    @Override
    public void notifyObservers(String message) {
        if(observerList == null || observerList.isEmpty()) {
            System.out.println("可通知列表为空!!!");
            throw new RuntimeException();
        }
        for(Observer observer : observerList) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.notifyObservers(message);
    }

}

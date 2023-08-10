package com.yangfan.playground.xjb.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


/**
 * @author mr_yo
 * 
 * point 1: observed
 */
public class BeWatched {
    
    List<Observer> oblist = new ArrayList<>();
    
    public BeWatched() {
        state = 1;
    }
    
    @Getter
    int state;
    
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    
    public void notifyAllObservers() {
        for (Observer ob : oblist) {
            ob.update();
        }
        System.out.println("----------------- Notification Completed. -----------------");
    }
    
    public void attach(Observer ob) {
        oblist.add(ob);
    }
    
    public boolean detach(Observer ob) {
        return oblist.remove(ob);
    }

}

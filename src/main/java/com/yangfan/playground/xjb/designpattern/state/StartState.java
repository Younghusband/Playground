package com.yangfan.playground.xjb.designpattern.state;

public class StartState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }
    
    public String toString() {
        return "Start state";
    }

}

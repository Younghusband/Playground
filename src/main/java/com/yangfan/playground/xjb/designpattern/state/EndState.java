package com.yangfan.playground.xjb.designpattern.state;

public class EndState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in end state");
        context.setState(this);
    }
    
    public String toString() {
        return "End State";
    }

}

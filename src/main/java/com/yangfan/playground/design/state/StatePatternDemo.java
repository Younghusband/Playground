package com.yangfan.playground.design.state;

public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        
        StartState start = new StartState();
        start.doAction(context);
        System.out.println(context.getState().toString());
        
        EndState end = new EndState();
        end.doAction(context);
        System.out.println(context.getState().toString());
    }
}

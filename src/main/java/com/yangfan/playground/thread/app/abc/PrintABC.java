package com.yangfan.playground.thread.app.abc;

public class PrintABC {
    private volatile int state = 0;
    private final int times;

    public PrintABC(int times) {
        this.times = times;
    }

    public void printA() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < times; i++) {
                while (state % 3 != 0) {
                    wait();
                }
                System.out.println("A");
                state++;
                notifyAll();
            }
        }
    }

    public void printB() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < times; i++) {
                while (state % 3 != 1) {
                    wait();
                }
                System.out.println("B");
                state++;
                notifyAll();
            }
        }
    }

    public void printC() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < times; i++) {
                while (state % 3 != 2) {
                    wait();
                }
                System.out.println("C");
                state++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC(10);

        new Thread(() -> {
            try {
                printABC.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                printABC.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                printABC.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State currentState = null;
        while (!isInterrupted()) {
            if (target.getState() != currentState) {
                currentState = target.getState();
                System.out.println(currentState);
                if (currentState == State.TERMINATED) return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

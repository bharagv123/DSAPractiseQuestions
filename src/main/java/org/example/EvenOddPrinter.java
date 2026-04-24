package org.example;

public class EvenOddPrinter {

    private int counter = 1;
    private final int MAX = 10;  // Up to which number to print
    private final Object lock = new Object();

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter();
        Thread evenThread = new Thread(() -> printer.printEven());
        Thread oddThread = new Thread(() -> printer.printOdd());
        evenThread.start();
        oddThread.start();
    }

    public void printOdd(){
        synchronized (lock) {
            while (counter<MAX){
                if (counter%2==0){
                    try {
                        lock.wait(); // // Wait until notified by the even thread release the Lock
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Odd  : " + counter);
                counter++;
                lock.notify();
            }
        }
    }

    public void printEven(){
        synchronized (lock) {
            while (counter<=MAX){
                if (counter%2==1){
                    try {
                        lock.wait(); // // Wait until notified by the even thread release the Lock
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Even : " + counter);
                counter++;
                lock.notify();
            }
        }
    }
}

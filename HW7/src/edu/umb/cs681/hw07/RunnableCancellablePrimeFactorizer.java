package edu.umb.cs681.hw07;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer {
    private boolean done;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        }
        finally {
            lock.unlock();
        }
    }

    public void generatePrimeFactors() {
        long divisor = from;
        while (dividend != 1 && divisor <= to) {
            lock.lock();
            try {
                if (done) {
                    System.out.print("Stopped generatePrimeFactors ");
                    break;
                }
                if (divisor > 2 && isEven(divisor)) {
                    divisor++;
                    continue;
                }
                if (dividend % divisor == 0) {
                    factors.add(divisor);
                    dividend /= divisor;
                } else {
                    if (divisor == 2) {
                        divisor++;
                    } else {
                        divisor += 2;
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("prime factors of 200 ");
        RunnableCancellablePrimeFactorizer r1 = new RunnableCancellablePrimeFactorizer(200, 2, 200);
        Thread t1 = new Thread(r1);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println();
        System.out.println("two thread produced prime factors of 204");
        RunnableCancellablePrimeFactorizer r2 = new RunnableCancellablePrimeFactorizer(250, 2, (long) Math.sqrt(250) / 2);
        RunnableCancellablePrimeFactorizer r3 = new RunnableCancellablePrimeFactorizer(250, (long) Math.sqrt(250) / 2 + 1, (long) Math.sqrt(250));
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t2.start();
        t3.start();
        try {
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println();
        System.out.println("Cancellable prime factors of 150 ");
        RunnableCancellablePrimeFactorizer r4 = new RunnableCancellablePrimeFactorizer(150, 2, 150);
        Thread t4 = new Thread(r4);
        t4.start();
        r4.setDone();
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

    }
}

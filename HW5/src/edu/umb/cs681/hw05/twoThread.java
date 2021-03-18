package edu.umb.cs681.hw05;

public class twoThread {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("two thread run:");
        RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 1000000L);
        RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(1000000L, 2000000L);
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        g1.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g2.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
        long endTime = System.currentTimeMillis();
        System.out.println("number of prime in total is " + (g1.getPrimes().size() + g2.getPrimes().size()));
        System.out.println("two thread run time : " + (endTime - startTime));
    }
}

package edu.umb.cs681.hw05;

public class fourThread {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("four thread run:");
        RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 500000L);
        RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(500000L, 1000000L);
        RunnablePrimeGenerator g3 = new RunnablePrimeGenerator(1000000L, 1500000L);
        RunnablePrimeGenerator g4 = new RunnablePrimeGenerator(1500000L, 2000000L);
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        Thread t3 = new Thread(g3);
        Thread t4 = new Thread(g4);
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        g1.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g2.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g3.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g4.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
        long endTime = System.currentTimeMillis();
        System.out.println("number of prime in total is " + (g1.getPrimes().size() + g2.getPrimes().size()
                + g3.getPrimes().size() + g4.getPrimes().size()));
        System.out.println("four thread run time : " + (endTime - startTime));
    }
}

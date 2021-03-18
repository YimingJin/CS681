package edu.umb.cs681.hw05;

public class eightThread {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("eight thread run:");
        RunnablePrimeGenerator g1 = new RunnablePrimeGenerator(1L, 250000L);
        RunnablePrimeGenerator g2 = new RunnablePrimeGenerator(250000L, 500000L);
        RunnablePrimeGenerator g3 = new RunnablePrimeGenerator(500000L, 750000L);
        RunnablePrimeGenerator g4 = new RunnablePrimeGenerator(750000L, 1000000L);
        RunnablePrimeGenerator g5 = new RunnablePrimeGenerator(1000000L, 1250000L);
        RunnablePrimeGenerator g6 = new RunnablePrimeGenerator(1250000L, 1500000L);
        RunnablePrimeGenerator g7 = new RunnablePrimeGenerator(1500000L, 1750000L);
        RunnablePrimeGenerator g8 = new RunnablePrimeGenerator(1750000L, 2000000L);
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        Thread t3 = new Thread(g3);
        Thread t4 = new Thread(g4);
        Thread t5 = new Thread(g5);
        Thread t6 = new Thread(g6);
        Thread t7 = new Thread(g7);
        Thread t8 = new Thread(g8);
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        g1.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g2.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g3.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g4.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g5.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g6.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g7.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
//        g8.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
        long endTime = System.currentTimeMillis();
        System.out.println("number of prime in total is " + (g1.getPrimes().size() + g2.getPrimes().size()
                + g3.getPrimes().size() + g4.getPrimes().size() + g5.getPrimes().size() + g6.getPrimes().size()
                + g7.getPrimes().size() + g8.getPrimes().size()));
        System.out.println("eight thread run time : " + (endTime - startTime));
    }
}

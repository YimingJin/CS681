package edu.umb.cs681.hw05;

public class oneThread {
    public static void main(String[] args) {
        System.out.println("one thread run:");
        RunnablePrimeGenerator g = new RunnablePrimeGenerator(1L,  2000000L);
        Thread t = new Thread(g);
        long startTime = System.currentTimeMillis();
        t.start();
        try{
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        g.getPrimes().forEach((Long prime)->System.out.print(prime + ", "));
        long endTime = System.currentTimeMillis();
        System.out.println("number of prime in total is " + g.getPrimes().size());
        System.out.println("one thread run time : " + (endTime - startTime));

    }
}

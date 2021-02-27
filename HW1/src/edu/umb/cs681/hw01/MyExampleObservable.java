package edu.umb.cs681.hw01;

public class MyExampleObservable {
    public static void main(String args[]) {
        StockQuoteObservable stock = new StockQuoteObservable();
        DJIAQuoteObservable djia = new DJIAQuoteObservable();
        stock.addObserver((Observable o, Object obj) -> {
            System.out.println("Stock Observer 1 notified.");
        });
        stock.changeQuote("Test1", 1);
        stock.addObserver((Observable o, Object obj) -> {
            System.out.println("Stock Observer 2 notified.");
        });
        stock.changeQuote("Test2", 2);
        djia.addObserver((Observable o, Object obj) -> {
            System.out.println("DJIA Observer 1 notified.");
        });
        djia.addObserver((Observable o, Object obj) -> {
            System.out.println("DJIA Observer 2 notified.");
        });
        djia.changeQuote("Test3", 3);
        djia.changeQuote("Test4", 4);

    }
}

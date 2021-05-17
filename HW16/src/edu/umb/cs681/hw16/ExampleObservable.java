package edu.umb.cs681.hw16;

public class ExampleObservable {
    public static void main(String[] args) {
        System.out.println("DJIAQuoteObservable: ");
        DJIAQuoteObservable djiaQuoteObservable = new DJIAQuoteObservable();

        djiaQuoteObservable.addObserver((Observable o, Object obj) ->
                System.out.println("DJIA observer1 has updated, quote is " + ((DJIAEvent) obj).getDJIA()));

        Observer observer2 = (Observable o, Object obj) ->
                System.out.println("DJIA observer2 has updated, quote is " + ((DJIAEvent) obj).getDJIA());

        djiaQuoteObservable.addObserver(observer2);

        djiaQuoteObservable.addObserver((Observable o, Object obj) ->
                System.out.println("DJIA observer3 has updated, quote is " + ((DJIAEvent) obj).getDJIA()));

        System.out.println("DJIA quote is set");

        djiaQuoteObservable.setQuote(1990.3f);

        System.out.println("current DJIAQuoteObservable size is " + djiaQuoteObservable.countObservers());
        djiaQuoteObservable.deleteObserver(observer2);
        System.out.println("After delete observer2, now current DJIAQuoteObservable size is " + djiaQuoteObservable.countObservers());

        //-------------------------------------------------------------------------------------------------

        System.out.println("");
        System.out.println("StockQuoteObservable: ");

        StockQuoteObservable stockQuoteObservable = new StockQuoteObservable();

        stockQuoteObservable.addObserver((Observable o, Object obj) ->
                System.out.println("Stock observer1 has updated, ticker is " + ((StockEvent)obj).getTicker()
                        + ", quote is " + ((StockEvent)obj).getQuote()));
        Observer stockObserver2 = (Observable o, Object obj) ->
                System.out.println("Stock observer2 has updated, ticker is " + ((StockEvent)obj).getTicker()
                        + ", quote is " + ((StockEvent)obj).getQuote());

        stockQuoteObservable.addObserver(stockObserver2);

        stockQuoteObservable.addObserver((Observable o, Object obj) ->
                System.out.println("Stock observer3 has updated, ticker is " + ((StockEvent)obj).getTicker()
                        + ", quote is " + ((StockEvent)obj).getQuote()));

        System.out.println("stock quote is set");

        stockQuoteObservable.setQuote("app", 192.3f);

        System.out.println("current StockQuoteObservable size is " + stockQuoteObservable.countObservers());
        stockQuoteObservable.deleteObserver(stockObserver2);
        System.out.println("After delete Stock observer2, now current StockQuoteObservable size is " + stockQuoteObservable.countObservers());

    }
}

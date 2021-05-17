package edu.umb.cs681.hw18;

public class StockQuoteObservable extends Observable {
    public void setQuote(String t, float q) {
        this.setChanged();
        this.notifyObservers(new StockEvent(t, q));
    }
}

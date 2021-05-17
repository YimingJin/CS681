package edu.umb.cs681.hw18;

public class DJIAQuoteObservable extends Observable {
    public void setQuote(float djia) {
        this.setChanged();
        this.notifyObservers(new DJIAEvent(djia));
    }
}

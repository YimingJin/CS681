package edu.umb.cs681.hw16;

public class DJIAQuoteObservable extends Observable {
    public void setQuote(float djia) {
        this.setChanged();
        this.notifyObservers(new DJIAEvent(djia));
    }
}

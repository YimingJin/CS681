package edu.umb.cs681.hw18;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable {
    private ConcurrentLinkedQueue<Observer> observers = new ConcurrentLinkedQueue<>();
    private AtomicBoolean changed = new AtomicBoolean(false);
    private ReentrantLock lock = new ReentrantLock();

    public Observable(){}

    public void addObserver(Observer obj) {
        if (obj != null) {
            observers.add(obj);
        }
    }

    public void deleteObserver(Observer obj) {
        observers.remove(obj);
    }

    public int countObservers() {
        return observers.size();
    }

    protected void setChanged() {
        changed.set(true); ;
    }

    protected void clearChanged() {
        changed.set(false);
    }

    public boolean hasChanged() {
        return changed.get() == true;
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object obj) {

        if (changed.get()) {
            observers.forEach((o) -> o.update(this, obj));
            clearChanged();
        }

    }
}

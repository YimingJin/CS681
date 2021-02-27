package edu.umb.cs681.hw01;

import java.util.LinkedList;

public abstract class Observable {
    private LinkedList<Observer> observer = new LinkedList<>();
    private boolean changed;
    public void addObserver(Observer o) {
        if (!observer.contains(o)) {
            observer.add(o);
        }
    }
    public void deleteObserver(Observer o) {
        if (observer.contains(o)) {
            observer.remove(o);
        }
    }
    public int countObserver() {
        return observer.size();
    }
    public boolean hasChanged() {
        return changed;
    }
    protected void setChanged() {
        changed = true;
    }
    protected void clearChanged() {
        changed = false;
    }
    public void notifyObservers(Object obj) {
        if (hasChanged()) {
            observer.forEach((Observer observer) -> observer.update(this, obj));
            clearChanged();
        }
    }
}

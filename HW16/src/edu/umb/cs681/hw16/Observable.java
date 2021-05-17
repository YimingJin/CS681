package edu.umb.cs681.hw16;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable {
    private LinkedList<Observer> observers = new LinkedList<>();
    private AtomicBoolean changed = new AtomicBoolean(false);
    private ReentrantLock lock = new ReentrantLock();

    public Observable(){}

    public void addObserver(Observer obj) {
        lock.lock();
        try {
            if (obj != null && !observers.contains(obj)) {
                observers.add(obj);
            }
        } finally {
            lock.unlock();
        }


    }

    public void deleteObserver(Observer obj) {
        lock.lock();
        try {
            observers.remove(obj);
        } finally {
            lock.unlock();
        }

    }

    public int countObservers() {
        lock.lock();
        try {
            return observers.size();
        } finally {
            lock.unlock();
        }

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
        LinkedList<Observer> copyedList;
        if (changed.get()) {
            lock.lock();
            try {
                copyedList = new LinkedList<Observer>(observers);
                clearChanged();
            } finally {
                lock.unlock();
            }

            for (Observer o : copyedList) {
                o.update(this, obj);
            }
        }

    }
}

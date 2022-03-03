package com.example.ascensuer;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * A levelSensor is an Observable
 * it knows the value of the level
 * when the value change, if notifies all the observers
 */
class LevelSensor extends Observable {
    private int currentLevel = 0;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        if ((Boolean) arg){
            if (currentLevel < MainActivity.LAST_LEVEL) {
                currentLevel++;
                for (Observer o : observers){
                    o.update(this, currentLevel);
                }
                Log.i("Ascend", "Going up");
                return;
            }
            Log.i("Ascend", "Already on top");
        } else {
            if (currentLevel > 0) {
                --currentLevel;
                for (Observer o : observers){
                    o.update(this, currentLevel);
                }
                Log.i("Ascend", "Going down");
                return;
            }
            Log.i("Ascend", "Already at the bottom");
        }
    }
}

package com.example.ascensuer;

import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * the Cabin is an observer (to the level floor)
 * It Knows the Display class reference (IDisplay interface)
 * it demands to display the new floor's value each time it is notified that the level floor has changed
 *
 * NOTE: the responsibility for the value to be displayed lies with this Cabin
 */
public class Cabin implements Observer  {

    public Cabin(MainActivity activity){
        this.mainActivity = activity;
        this.lift = mainActivity.findViewById(R.id.imageLift);
    }

    private final MainActivity mainActivity;
    private final ImageView lift;

    @Override
    public void update(Observable observable, Object level) {
        Log.i("Ascend", String.valueOf(level));
        if (level instanceof Integer) {
            Log.i("Ascend", "Level " + level);
            mainActivity.displayLevel("Level " + level);
            mainActivity.moveLiftView(lift, (Integer) level);
        }
    }
}

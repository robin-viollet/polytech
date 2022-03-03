package com.example.ascensuer;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * manage the View
 *  - allow the user to press button Up and Down
 *  - display current level
 *  - play the animation of the lift move
 *
 *  this activity create the Obervable and the Obervers (just one in this case)
 *  NOTE: the Observers (cabine) is informed each time a new level is reached
 *        Observable (sensor) know the value of the level, when the value change, just notify all the observers
 *        The level is set to -1 when lift is being to chang floor (animation)
 *        the level is set to orderLevel when animation is finished
 *
 *  NOTE: the responsibility for the value to be displayed lies with Observer, not to this controller !
 */
public class MainActivity extends AppCompatActivity implements IDisplay{
    private final static int OFFSET = 286;
    public static final int SPEED = 2000;
    public static final int LAST_LEVEL = +3;
    public static final int FIRST_LEVEL = 0;
    private TextView tvCurrentLevel;
    private final LevelSensor levelSensor = new LevelSensor();
    Cabin cabin;  //this will be able to display the Level

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cabin = new Cabin(this);

        levelSensor.addObserver(cabin);   //add Cabin as observer


        //get widgets
        tvCurrentLevel = findViewById(R.id.textCurrentLevel);
        
		//control buttons

        findViewById(R.id.buttonUp).setOnClickListener( click -> {
            levelSensor.notifyObservers(true);
        });

        findViewById(R.id.buttonDown).setOnClickListener( click -> {
           levelSensor.notifyObservers(false);
        });
    }

    void moveLiftView(View liftCabin, final int positionOrder) {
		//In the real life, The sensor automatically detect the presence
		//but not possible here --> so please think to change sensor's value from this method.
        liftCabin.animate().translationY(-positionOrder * OFFSET).setDuration(SPEED).setInterpolator(new AccelerateDecelerateInterpolator());
    }

    /**
     * the observer can demand this Display agent to change
     * @param string the string to display
     */
    @Override
    public void displayLevel(String string) {
        tvCurrentLevel.setText(string);
    }

}

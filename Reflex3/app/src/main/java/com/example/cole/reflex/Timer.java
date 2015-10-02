package com.example.cole.reflex;

import android.os.CountDownTimer;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

/**
 * ABSTRACT CLASS TIMER!
 * This class is the ABSTRACT class of the two different timers that I care about.
 * Subclasses of this timer are
 * #1: RecordingTimer, the timer determining if you have a 10-2000ms break
 * #2: MisplayTimer, yielding 6 seconds before the next round
 */
public abstract class Timer {



    //Attributes of the Timer Abstract Class
    protected EditText onTickEditText;
    public Toast toastToUse;
    GameMode currentGameMode;

    //Constructor
    public Timer(EditText givenTickEditText, Toast toastToUtilize, GameMode givenCurrentGameMode) {

        onTickEditText = givenTickEditText;
        toastToUse = toastToUtilize;
        currentGameMode = givenCurrentGameMode;

    }

    //Allows a significantly reduced constructor to be formed.
    public Timer(EditText onTickEditText, GameMode givenCurrentGameMode) {
        this.onTickEditText = onTickEditText;
        currentGameMode = givenCurrentGameMode;
    }

    //Function called upon the Timer object to actually provide a time element.
    protected void timerCountdown(int finishTime, final EditText onTickEditText, final String
                                  onTickGivenText, final GameMode currentGameMode){
        new CountDownTimer(finishTime, 1000) {

            public void onTick(long millisUntilFinished) {

                onTickEditText.setText(onTickGivenText);
            }

            public void onFinish() {

                toastToUse.show();
                currentGameMode.gameModeSetBoolean(); //We ARE done, so set boolean.
                currentGameMode.clickableButtonStartTime(); //Store value of start time.


            }
        }.start();
    }





    //Method overloading for Timer object where we will provide a time element with reduced ability
    //In this method, I reduced the parameters of specifying requirement of
    //the duration of the timer. Here I have it automatically set to 6.
    protected void timerCountdown(final EditText onTickEditText, final GameMode currentGameMode){
        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {

                onTickEditText.setText("Restarting in..." + millisUntilFinished / 1000);
            }

            public void onFinish() {

                toastToUse.show();
                //  currentGameMode.gameModeSetBoolean(); //We ARE done, so set boolean.


            }
        }.start();
    }


}

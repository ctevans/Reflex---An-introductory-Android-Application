package com.example.cole.reflex;

import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * This class is the actual object that extends the Timer (abstract) class, this will be called upon
 * in the program to create a timer specifically created for the exclusive purpose of providing
 * a time between 10-2000ms (as requested).
 */
public class RecordingTimer extends Timer{

    String recordingTimerText = "RecordingTimer text";

    //General constructor
    public RecordingTimer(EditText givenTickEditText, Toast toastToUse, GameMode currentMode) {
        super(givenTickEditText, toastToUse, currentMode);
    }

    //Formulation of the proper specific command to the Abstract Timer class!
    public void beginRecordingTimer(EditText onTickEditText){
        //This small block here will be the RNG that will determine the time for the
        Random rand = new Random();
        int rngDeterminedTime = rand.nextInt(1990);
        rngDeterminedTime = rngDeterminedTime +10; //To balance out start point of 10ms to 2000ms!

        //Call the superclass method with this RNG determined time.
        super.timerCountdown(rngDeterminedTime, onTickEditText, recordingTimerText,
                currentGameMode);
    }


}

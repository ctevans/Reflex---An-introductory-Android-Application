package com.example.cole.reflex;

import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Cole on 2015-10-01.
 * This timer is meant to give a small countdown before the next
 */
public class MisplayTimer extends Timer {

    public MisplayTimer(EditText givenTickEditText, GameMode givenCurrentGameMode) {
        super(givenTickEditText, givenCurrentGameMode);
    }

    public void beginMisplayTimer(){
        this.timerCountdown(onTickEditText, currentGameMode);


    }
}

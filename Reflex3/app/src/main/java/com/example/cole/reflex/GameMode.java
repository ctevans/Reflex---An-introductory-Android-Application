package com.example.cole.reflex;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This is going to be the extremely generic "Game Mode" that will provide the basic functionality
 * to each of the particular modes of play.
 *
 * What it will do:
 * It will create a timer object which will give recordings of the activities of the players
 */
public class GameMode {

    private EditText textLineToModify;
    public Toast toastRecord;
    Button buttonToPress;
    private boolean areWeThereYet;
    long recordedStartTime;
    long recordedEndTime;

    //timerBoolean is going to be a boolean value that is fed into the timer functions
    //which will tell me if the timer is finished (when it is set to true) or if it is
    //not finished yet (set to false).
    final long[] long_array = new long[1];



    // General constructor to be called by other functions in the program.
    // Anything attempting to create a GameMode object MUST supply a line that this
    // game mode object can modify.
    public GameMode(EditText textLine, Toast toast, Button givenButtonToPress) {
        textLineToModify = textLine;
        toastRecord = toast;
        buttonToPress = givenButtonToPress;
    }

    //This method called upon the object will begin the recording timer in the GameMode object
    //and set the text handed to the object.
    public void gameModeBegin(){
        textLineToModify.setText("Prepare to click!");
        RecordingTimer gameModeTimer = new RecordingTimer(textLineToModify, toastRecord, this);
        gameModeTimer.beginRecordingTimer(textLineToModify);
        buttonToPress.setVisibility(View.VISIBLE);
        areWeThereYet = false;





    }

    //This method allows one to set the boolean "areWeThereYet" to true.
    //Acts as a flagging system that the timers can utilize to say they are finished
    public void gameModeSetBoolean(){
        areWeThereYet = true;
    }

    //Method giving the current value of the boolean flag areWeThereYet
    public boolean gameModeGetBoolean(){
        return areWeThereYet;
    }


    //This method is called when we have had the user press the button too early (so sad...)
    public void gameModeDoneTooEarly(){
        textLineToModify.setText("TOO EARLY, FOOL!");
        MisplayTimer misplayTimer = new MisplayTimer(textLineToModify, this);

        misplayTimer.beginMisplayTimer();


    }

    //This method is called when we have successfully achieved the game mode being completed!
    public void gameModeDoneSuccess(){
        textLineToModify.setText("SUCCESS!");
        clickableButtonEndTime(); // Obtain the time when the user successfully clicked the button

        long timeDifference = obtainTimeDifference(recordedStartTime, recordedEndTime);
        SingleStatistics singleStatisticsObject = new SingleStatistics(timeDifference);



    }

    //When called the activity will be reset, plain and simple.
    //Main use is actually in the misplay timer to be honest.
    public void gameReset(){


    }


    /** The next 3 functions are especially dedicated to obtaining the
     * amount of time between when the button was made clickable to when the user clicked the
     * button.
     **/
    //The first returns a long value of a starting time (a particular nano time value)

    public void clickableButtonStartTime(){
        long buttonStartTime = System.nanoTime();
        recordedStartTime =  buttonStartTime;;
    }
    //The second returns another long value of a second nano time.
    public void clickableButtonEndTime(){
        long buttonEndTime = System.nanoTime();
        recordedEndTime =  buttonEndTime;
    }

    //This third function calculates the difference between the startTime and the endTime
    public long obtainTimeDifference(long startTime, long endTime){
        long howLongItTook = endTime - startTime;
        return(howLongItTook);

    }



}

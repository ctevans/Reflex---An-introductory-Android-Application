package com.example.cole.reflex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SinglePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);


        /** Initialization of Activity.
         * Initialize (buttons, texts, on click listeners)
         */

        //Create the toast that will tell the player when they are allowed to click
        final Toast toast = Toast.makeText(getApplicationContext(), "Click the button NOW!",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);


        //Initialize buttons
        final Button singlePlayerBeginButton = (Button) findViewById(R.id.singlePlayerBeginButton);
        final Button pressThisButton = (Button) findViewById(R.id.pressThisButton);



        //Initialize texts
        final TextView spTextDescription = (TextView) findViewById(R.id.spTextDescription);
        final EditText gameModeTellText = (EditText) findViewById(R.id.gameModeTellText);

        //Initialize visuals, and their restrictions
        pressThisButton.setVisibility(View.GONE);

        //Initialize TEMPORARY HOLDER for the future GameMode object!
        final GameMode[] gameModeHolder = new GameMode[1];



        singlePlayerBeginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /** Initialize game mode, initialize visuals, remove old visuals **/
                //Remove old visuals
                singlePlayerBeginButton.setVisibility(View.GONE);
                spTextDescription.setVisibility(View.GONE);

                //Make active game mode visuals visible


                //Create new GameMode object
                //Hand it the "gameModeTellText" edit text box. GameMode object will act upon it
                GameMode singlePlayerGameMode = new GameMode(gameModeTellText, toast,
                        pressThisButton);
                gameModeHolder[0] = singlePlayerGameMode;
                singlePlayerGameMode.gameModeBegin();


                /** Now we have a GameMode object I will call it's methods to have the game
                 * occur
                 **/


            }

        });

        pressThisButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(gameModeHolder[0].gameModeGetBoolean() == false){
                    gameModeHolder[0].gameModeDoneTooEarly();

                }
                else{
                    gameModeHolder[0].gameModeDoneSuccess();

                }





            }

        });









    }





}

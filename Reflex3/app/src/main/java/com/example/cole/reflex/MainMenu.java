package com.example.cole.reflex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        /** Initialize all buttons **/
        Button singlePlayerModeButton = (Button) findViewById(R.id.singlePlayerModeButton);
        Button multiPlayerModeButton = (Button) findViewById(R.id.multiPlayerModeButton);
        Button statisticsScreenButton = (Button) findViewById(R.id.statisticsScreenButton);


        /** Initialize DataManager **/
        DataManager dataManager = new DataManager();



        /** On click methods for each of the buttons.
         * The purpose of this page is to act as a gateway to various pages of the app.
         */
        singlePlayerModeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ //WhenButtonClicked
                startActivity(new Intent(MainMenu.this, SinglePlayer.class));
                // Way to open a new activity obtained from
                // http://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity-in-android-studio
                // username: SwiftArchitect, Gilad Haimov.
            }

        });

        multiPlayerModeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ //WhenButtonClicked
                startActivity(new Intent(MainMenu.this, MultiplayerOptions.class));
                // Way to open a new activity obtained from
                // http://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity-in-android-studio
                // username: SwiftArchitect, Gilad Haimov.
            }

        });

        statisticsScreenButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ //WhenButtonClicked
                startActivity(new Intent(MainMenu.this, Statistics.class));
                // Way to open a new activity obtained from
                // http://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity-in-android-studio
                // username: SwiftArchitect, Gilad Haimov.
            }

        });



















    }

}

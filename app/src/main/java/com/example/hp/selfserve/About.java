package com.example.hp.selfserve;

import android.content.Intent;
import android.service.voice.VoiceInteractionService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.button;

public class About extends AppCompatActivity {

    Button submitbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {       //when an activity is first launched its the job of onCreate method to launch it
        super.onCreate(savedInstanceState);                     //saved instancestate is passed as an argument to save the current activity of the application
        setContentView(R.layout.activity_about);        //used for Android UserInterface to display the Layout created thorugh XML or the Dynamically created layout with data in it.

        submitbutton = (Button) findViewById(R.id.loginCheck);      //findViewbyId is usedto retrieve the widgets in that UI that needs to be interacted with programmatically

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //this describes what series of actions take place when Submit button is pressed

                Intent i = new Intent(About.this,Home.class); //switching of the activities is described (from->to), this pointer refers to the current activity(about.class)
                startActivity(i);
                Toast.makeText(About.this, "WELCOME", Toast.LENGTH_SHORT).show(); //Toast here is used to display a short floating text on click of submit button.
            }
        });

    }
}

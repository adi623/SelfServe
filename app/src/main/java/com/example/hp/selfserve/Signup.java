package com.example.hp.selfserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signup extends AppCompatActivity {

    Button Signup; // a variable of type Button is created

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //initialization of the activity is done by onCreate method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);       //this line mentiones that main activity handles request for activity_signup.xml

        Signup = (Button) findViewById(R.id.submit);    // (button) is used for typecasting and signup is assigned a value searched by the id of the button(here->submit in signup.xml)

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {       // it describes wht happens when signup is pressed
                Intent i = new Intent(Signup.this,About.class); //movement of activity from the current specified activity to About.class is specified
                startActivity(i);       // to launch the activity start activity is used passing the intent as the argument
            }
        });
    }
}
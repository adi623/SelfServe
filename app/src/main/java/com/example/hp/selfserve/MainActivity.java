package com.example.hp.selfserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  //main activity class takes care of the activity_main.xml and its activities( image,login & signup text fields and help text element.
{

    ImageView logoImage;                    //declaration of image variable of data type ImageView
    TextView loginTF, signupTF, helpTF;     //declaration of three text field variables of type TextView

    @Override
    protected void onCreate(Bundle savedInstanceState)  //onCreate method describes the functionality that takes place when activity is created
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //this line mentiones that main activity handles request for activity_main.xml

        logoImage = (ImageView)findViewById(R.id.logo);     //logoImage is assigned a value searched by the id of the image(it is repressented by unique id put in xml file)
        loginTF = (TextView) findViewById(R.id.login);      //loginTF is assigned a value searched by the id of the textfield(it is repressented by unique id put in xml file)
        signupTF = (TextView) findViewById(R.id.signup);    //signupTF is assigned a value searched by the id of the textfield(it is repressented by unique id put in xml file)
        helpTF = (TextView) findViewById(R.id.help);        //helpTF is assigned a value searched by the id of the textfield(its functionality is yet to be implemented)

   loginTF.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {                        //this describes what series of actions take place when login textfield(here, used as a button) is pressed.
           Intent i = new Intent(MainActivity.this,About.class);    //movementof program from current activity to the specified activity(here its About.class) is specified
           startActivity(i);                                        //on starting the intent the switching of android views takes place on click
       }
   });

        signupTF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {               //this describes what series of actions take place when Signup textfield(here, used as a button) is pressed.
                Intent i = new Intent(MainActivity.this,Signup.class);  //movementof program from current activity to the specified activity(here its Signup.class) is specified
                startActivity(i);                                       //on starting the intent the switching of android views takes place on click
            }
        });

        logoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {               //this describes the set of actions to be performed when the image(logo) is clicked
                Intent i = new Intent(MainActivity.this,AboutCreater.class); // movement of program from current activity to the specified activity(here, its about developer or creator) is specified
                startActivity(i);                               //on starting the intent or activity the actual switching of activities take place
            }
        });



    }
}


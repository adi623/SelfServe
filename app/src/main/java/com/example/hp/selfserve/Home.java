package com.example.hp.selfserve;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Home extends AppCompatActivity
{

     Button scann_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // it represents the xml activity that this java file has to handle. here is it activity_home.xml

        scann_btn = (Button) findViewById(R.id.scan_btn); // button object(scann_btn) finds the button activity by searching fir its id(here its scan_btn)
        final Activity activity= this;
        scann_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                IntentIntegrator integrator= new IntentIntegrator(activity);    //IntentIntegrator is class from com.google.zxing.integration.android.IntentIntegrator package which is used for identify Qr Code content
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan");   //scan toast appears on the scanning screen on the press of the scan button.
                integrator.setCameraId(0);  //camera id is set to 0 to activate the camera via the activity
                integrator.setBeepEnabled(false);   //beeping on the scanning is disabled
                integrator.setBarcodeImageEnabled(false); //the square border of the code scanning screen is disables by providing false as argument
                integrator.initiateScan();  //the scanning process takes place when initiatescan() method is activated.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) //this block of code is copied from a youtube tutorial on how to activate the scanning of the QRCode through accessing the camera through our application.
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result !=null)
            {
                if(result.getContents() == null)
                {
                    Toast.makeText(this,"You Cancelled the Scanning", Toast.LENGTH_LONG).show();    //if back is presssed during scanning then the specified message is displayed.
                }
                else {
                    Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();    //displayes the contents of the scanned QRCode
                }
            }
            else
            {
                super.onActivityResult(requestCode, resultCode, data);
            }
    }
}

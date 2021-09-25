package com.Exercise4.locationgeocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.support.v7.app.ActionBarActivity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	TextView t1;
	EditText e1;
	Button b;
	double LATITUDE = 37.42233;
	double LONGITUDE = -122.083;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //t1 = (TextView)findViewById(R.id.textView3);
        addListenerOnButtonClick();
    }
	public void addListenerOnButtonClick(){  
		e1 = (EditText)findViewById(R.id.editText1);
		b = (Button)findViewById(R.id.button1);
		t1 = (TextView)findViewById(R.id.textView3);
        b.setOnClickListener(new View.OnClickListener(){          	  
            @Override  
            public void onClick(View view) {
            	Geocoder geocoder = new Geocoder(MainActivity.this, Locale.ENGLISH);

                try {
           List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
          
           if(addresses != null) {
            Address returnedAddress = addresses.get(0);
            StringBuilder strReturnedAddress = new StringBuilder("Address:\n");
            for(int i=0; i<returnedAddress.getMaxAddressLineIndex(); i++) {
             strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
            }
            t1.setText(strReturnedAddress.toString());
           }
           else{
            t1.setText("No Address returned!");
           }
          } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           t1.setText("Canont get Address!");
          }
            }
        });
            
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}

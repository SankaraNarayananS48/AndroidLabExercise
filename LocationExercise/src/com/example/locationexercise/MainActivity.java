package com.example.locationexercise;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
//import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
//import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
	Button b;
	EditText e1;
	TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView)findViewById(R.id.textView3);
        b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	e1	= (EditText) findViewById(R.id.editText1);
                String address = e1.getText().toString();
                Geocodingloacation locationAddress = new Geocodingloacation();
                locationAddress.getAddressFromLocation(address,
                        getApplicationContext(), new GeocoderHandler());	
            }      
        });
    }
    @SuppressLint("HandlerLeak") private  class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message message) {
            String locationAddress="";
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            t1.setText(locationAddress);
        }
    }

    @Override
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
    }
}

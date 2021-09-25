package com.Exercise6.ex6location;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	TextView t1;
	EditText e1;
	Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){  
		e1 = (EditText)findViewById(R.id.editText1);
		b = (Button)findViewById(R.id.button1);
		t1 = (TextView)findViewById(R.id.textView3);
        b.setOnClickListener(new View.OnClickListener(){          	  
            @Override  
            public void onClick(View view) {
            	Thread thread=new Thread(){
                    @Override
                    public void run() {
                        Geocoder code=new Geocoder(MainActivity.this, Locale.getDefault());
                        String locaddr = e1.getText().toString();
                        String result=null;
                        try {
                            List<Address> addrlist=code.getFromLocationName(locaddr,1);
                            if(addrlist!=null && addrlist.size()>0){
                                Address address=(Address)addrlist.get(0);
                                StringBuilder build=new StringBuilder();
                                build.append(address.getLatitude()).append("\n");
                                build.append(address.getLongitude()).append("\n");
                                result=build.toString();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally {
                            if(result!=null){
                                result="Address     :"+locaddr+"\n\n\n Latitude and longitude are"+result;
                                t1.setText(result);
                            }
                        }
                    }
                };
                thread.start();
            	
            }
        });
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

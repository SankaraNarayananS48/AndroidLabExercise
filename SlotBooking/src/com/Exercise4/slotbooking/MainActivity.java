package com.Exercise4.slotbooking;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.PendingIntent;  
import android.app.TimePickerDialog;
import android.app.DatePickerDialog;
import android.content.Intent;  
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;  
import android.widget.ArrayAdapter;
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.Spinner;
import android.widget.Toast;  
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;
import android.widget.AdapterView;  
import android.widget.ArrayAdapter;  

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener{
	EditText name,date,time,phonne;
	Button button;
	DatePickerDialog dpicker;
	TimePickerDialog tpicker;
	String cname="";
	String[] cnames = { "Chennai-North", "Chennai-South", "Chennai-West", "Chennai-East", "Chennai-NorthEast"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
        Spinner spin = (Spinner) findViewById(R.id.spinner1);  
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cnames);  
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        //Setting the ArrayAdapter data on the Spinner  
        spin.setAdapter(aa);
    }
    @Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {  
		cname=cnames[position]+"\n";  
    } 
	@Override  
    public void onNothingSelected(AdapterView<?> arg0) {  
        // TODO Auto-generated method stub  
    } 

    public void addListenerOnButtonClick(){ 
        name=(EditText)findViewById(R.id.editText1);  
        date=(EditText)findViewById(R.id.editText2);
        phonne=(EditText)findViewById(R.id.editText4);
        //date.setInputType(InputType.TYPE_NULL);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                dpicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                dpicker.show();
            }
        });
        time=(EditText)findViewById(R.id.editText3); 
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                tpicker = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                time.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                tpicker.show();
            }
        });
        button=(Button)findViewById(R.id.button1);  
        button.setOnClickListener(new OnClickListener(){              
            @Override  
            public void onClick(View view) {  
                String namee=name.getText().toString();  
                String datee=date.getText().toString();  
                String timee=time.getText().toString();
                String phonenoo = phonne.getText().toString();
                String msg="Vaccine Slot Booked"+"\n"+"Vaccine:Covishield"+"\n"+"Name:"+namee+"\n"+"Date:"+datee+"\n"+"Time:"+timee+"\n"+"Center name:"+cname+"\n"+"Wear Mask Maintain Social Distance";
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
                SmsManager sms=SmsManager.getDefault();  
                sms.sendTextMessage(phonenoo, null, msg, pi,null);    
                Toast.makeText(getApplicationContext(), "Message Sent successfully!",  
                Toast.LENGTH_LONG).show(); 
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

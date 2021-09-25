package com.Exercise1.taxcalculator;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;  
import android.view.View.OnClickListener;  
import android.app.AlertDialog;  
import android.content.DialogInterface;  
import android.widget.Button;  
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	private Button b;
	private EditText e1,e2,e3,e4,e5,e6,e7;
	AlertDialog.Builder builder; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();  
        builder = new AlertDialog.Builder(this);
    }
    public void addListenerOnButtonClick(){  
		e1 = (EditText)findViewById(R.id.editText1);
		e2 = (EditText)findViewById(R.id.editText2);
		e3 = (EditText)findViewById(R.id.editText3);
		e4 = (EditText)findViewById(R.id.editText4);
		e5 = (EditText)findViewById(R.id.editText5);
		e6 = (EditText)findViewById(R.id.editText6);
		e7 = (EditText)findViewById(R.id.editText7);
		b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener(){          	  
            @Override  
            public void onClick(View view) {  
            	int bpay=Integer.parseInt(e1.getText().toString());
            	int dallowance=Integer.parseInt(e2.getText().toString());
            	int houseallowance=Integer.parseInt(e3.getText().toString());
            	int medicalallowance=Integer.parseInt(e4.getText().toString());
            	int providancefund=Integer.parseInt(e5.getText().toString());
            	int healthfund=Integer.parseInt(e6.getText().toString());
            	int proftax=Integer.parseInt(e7.getText().toString());
            	double tax=0;
            	int totalsalary = (bpay+dallowance+houseallowance+medicalallowance)*12;
            	int deduction=(providancefund+healthfund+proftax)*12;
            	int amount=totalsalary-deduction;
            	if(amount<=200000)
            		tax=0;
            	else if(amount<=300000)
            		tax=0.1*(amount-200000);
            	else if(amount<=500000)
            		tax=(0.2*(amount-300000))+(0.1*100000);
            	else if(amount<=1000000)
            		tax=(0.3*(amount-500000))+(0.2*200000)+(0.1*100000);
            	else
            		tax=(0.4*(amount-1000000))+(0.3*500000)+(0.2*200000)+(0.1*100000);
            	String result="Tax Amount :"+String.valueOf(tax);
            	builder.setMessage(result);
            	builder.setCancelable(false)  
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialog, int id) {  
                        finish();   
                    }  
                })  
                .setNegativeButton("No", new DialogInterface.OnClickListener() {  
                    public void onClick(DialogInterface dialog, int id) {  
                        //  Action for 'NO' Button  
                        dialog.cancel();  
                    }  
                });  
            	AlertDialog alert = builder.create();    
            	alert.setTitle("Tax Amount");  
            	alert.show();
            	
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

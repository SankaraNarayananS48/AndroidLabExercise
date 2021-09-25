package com.Exercise1.bmi;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;   
import android.view.Menu; 
import android.view.MenuItem;
import android.view.View;  
import android.view.View.OnClickListener;  
import android.app.AlertDialog;  
import android.content.DialogInterface;  
import android.widget.Button;  
import android.widget.Toast;  
import android.widget.EditText;
public class MainActivity extends ActionBarActivity {

	private Button b;
	private EditText e1,e2;
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
		b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener(){          	  
            @Override  
            public void onClick(View view) {  
            	double h=Double.parseDouble(e1.getText().toString());
            	double w=Double.parseDouble(e2.getText().toString());
            	double result = (w/(h*h));
                if(result>=18.5 && result<=24.9){
                	Toast.makeText(getApplicationContext(),"Normal",Toast.LENGTH_LONG).show();}
                else{
                	if(result<18.4){ builder.setMessage("Under weight");}
                	else{builder.setMessage("OverWeight");}
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
            //Creating dialog box  
            AlertDialog alert = builder.create();  
            //Setting the title manually  
            alert.setTitle("BMI Result");  
            alert.show();
                }
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

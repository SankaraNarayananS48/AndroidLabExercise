package com.Exercise1.rating;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;  
import android.widget.AdapterView;  
import android.widget.ArrayAdapter;  
import android.widget.Spinner;  
import android.widget.Toast; 
import android.widget.Button;  
import android.widget.RatingBar;  
public class MainActivity extends ActionBarActivity  implements  AdapterView.OnItemSelectedListener{

	String[] phone = { "Samsung F62", "Oneplus Nord", "Redmi 11", "Poco x1", "Vivo v11"};
	private RatingBar ratingbar;  
    private Button button;
    private String phonename; 
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick(); 
        Spinner spin = (Spinner) findViewById(R.id.spinner1);  
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,phone);  
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        //Setting the ArrayAdapter data on the Spinner  
        spin.setAdapter(aa); 
    }
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {  
		phonename=phone[position]+"\n";  
    } 
	@Override  
    public void onNothingSelected(AdapterView<?> arg0) {  
        // TODO Auto-generated method stub  
    } 
	 public void addListenerOnButtonClick(){  
	        ratingbar=(RatingBar)findViewById(R.id.ratingBar1);  
	        button=(Button)findViewById(R.id.button1);  
	        //Performing action on Button Click  
	        button.setOnClickListener(new View.OnClickListener(){  
	  
	            @Override  
	            public void onClick(View view) {  
	                //Getting the rating and displaying it on the toast  
	                phonename+="Rating:"+String.valueOf(ratingbar.getRating());  
	                Toast.makeText(getApplicationContext(), phonename, Toast.LENGTH_LONG).show();  
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

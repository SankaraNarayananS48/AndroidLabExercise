package com.Exercise3.explictquiz;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;



public class MainActivity extends ActionBarActivity {
	private Button b;
	private CheckBox ans1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    
    public void addListenerOnButtonClick(){  
    	ans1 = (CheckBox)findViewById(R.id.checkBox2); 
    	//ans2 = (CheckBox)findViewById(R.id.checkBox4);
    	//ans3 = (CheckBox)findViewById(R.id.checkBox7);
		b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener(){          	  
            @Override  
            public void onClick(View view) {
            	int value=0;
            	if(ans1.isChecked()){ value+=1; } 
            	//if(ans2.isChecked()){ value+=1; }
            	//if(ans3.isChecked()){ value+=1; }
            	String result  = Integer.toString(value);
            	Intent i = new Intent(getApplicationContext(), Ques2.class);  
                i.putExtra("Result", result);   
                startActivity(i);  
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


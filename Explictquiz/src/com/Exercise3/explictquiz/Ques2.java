package com.Exercise3.explictquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Ques2 extends Activity {
	private Button b;
	private CheckBox ans1;
	String result;
		  @Override  
		  public void onCreate(Bundle bundle) {  
		    super.onCreate(bundle);  
		    setContentView(R.layout.activity_questwo);  
		    Bundle extras = getIntent().getExtras();  
		    result = extras.getString("Result"); 
		    ans1 = (CheckBox)findViewById(R.id.checkBox2); 
			b = (Button)findViewById(R.id.button1);
	        b.setOnClickListener(new View.OnClickListener(){          	  
	            @Override  
	            public void onClick(View view) {
	            	int value=Integer.parseInt(result);
	            	if(ans1.isChecked()){ value+=1; } 
	            	String result  = Integer.toString(value);
	            	Intent i = new Intent(getApplicationContext(), Thirdques.class);  
	                i.putExtra("Result", result);   
	                startActivity(i);  
	            }
	        });
		    
		  }
}

package com.Exercise5.bookdb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewResult extends Activity {
	private Button b;
	private TextView t1;
	String result;
	@Override  
	  public void onCreate(Bundle bundle) {  
	    super.onCreate(bundle);  
	    setContentView(R.layout.viewresult);  
	    Bundle extras = getIntent().getExtras();  
	    result = extras.getString("Result"); 
	    t1 = (TextView)findViewById(R.id.textView2);
	    t1.setText(result);
		b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener(){          	  
          @Override  
          public void onClick(View view) {
          	Intent i = new Intent(getApplicationContext(), MainActivity.class);     
              startActivity(i);  
          }
      });
	    
	  }
}

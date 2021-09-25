package com.Exercise3.explictquiz;


import android.app.Activity;  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;    
import android.widget.EditText; 
import android.widget.Toast;  
//import android.content.Intent;

public class ScoreDisplay extends Activity {  
/** Called when the activity is first created. */  
  @Override  
  public void onCreate(Bundle bundle) {  
    super.onCreate(bundle);  
    setContentView(R.layout.activity_second);  
    Bundle extras = getIntent().getExtras();  
    String result = extras.getString("Result");  
    EditText e1 = (EditText)findViewById(R.id.editText1);
    e1.setText(result);
    Toast.makeText(getApplicationContext(),"Score:"+result,Toast.LENGTH_LONG).show();  
    Button button1=(Button)findViewById(R.id.button1);  
    button1.setOnClickListener(new OnClickListener(){  
        public void onClick(View view) {  
            Intent i = new Intent(getApplicationContext(), MainActivity.class);  
            startActivity(i);  
          }  
    });  
  }  
}   
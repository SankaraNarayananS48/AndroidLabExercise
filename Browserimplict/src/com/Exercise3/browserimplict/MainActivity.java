package com.Exercise3.browserimplict;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent; 
import android.net.Uri;  


public class MainActivity extends ActionBarActivity {
	private Button b;
	private EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){  
		e1 = (EditText)findViewById(R.id.editText1);
		b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener(){          	  
            @Override  
            public void onClick(View view) {
            	String url=e1.getText().toString();  
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));  
                startActivity(intent);  
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

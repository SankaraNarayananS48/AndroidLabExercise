package com.Exercise2.mycaroption;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;  
import android.widget.EditText;
import android.widget.PopupMenu; 
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

	private Button b;
	private EditText e1;
	TextView t1;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
	public void addListenerOnButtonClick(){  
		e1 = (EditText)findViewById(R.id.editText1);
		b = (Button)findViewById(R.id.button1);
		t1 = (TextView)findViewById(R.id.textView2);
        b.setOnClickListener(new View.OnClickListener(){          	  
            @Override  
            public void onClick(View view) {
            	PopupMenu popup = new PopupMenu(MainActivity.this, b);  
                //Inflating the Popup using xml file  
                popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());  
  
                //registering popup with OnMenuItemClickListener  
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {  
                    public boolean onMenuItemClick(MenuItem item) {  
                        //Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();  
                        //return true;
                    	String suz="Slide in behind the wheel of this Mini SUV and make the world look up. With a commanding stance that lets you scope the fun around you, gear up for an exciting driving experience that makes you feel alive!";
                		String benz="Mercedes-Benz of Cary Purchasing a new vehicle is a big decision. One that should not be taken lightly. Many factors go into choosing the right vehicle. What may be important to you may not be so important to someone else. And that is ok. Mercedes-Benz, the first car company in the world, offers a wide variety of vehicles with a wide variety of features.";
                		String auddi="The Audi community is more than a passionate collective of like-minded drivers. We want everyone to be able to find and embrace their passion through mobility, sports, art, and projects that define who they are. Learn how Audi is helping others drive their passion here.";
                    	String var=item.getTitle().toString();
                    	if(var.equals("Maruti-Suzuki")){
                    		t1.setText("Maruti-suzuki");
                    		e1.setText(suz);}
                    	else if(var.equals("Audi")){
                    		t1.setText("Audi");
                    		e1.setText(auddi);
                    	}
                    	else{
                    		t1.setText("Benz");
                    		e1.setText(benz);}
                    	return true;
                    }
                });
                popup.show();
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
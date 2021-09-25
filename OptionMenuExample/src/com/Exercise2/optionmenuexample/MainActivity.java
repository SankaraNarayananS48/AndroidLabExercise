package com.Exercise2.optionmenuexample;

import java.util.ArrayList;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
//import android.widget.AdapterView.AdapterContextMenuInfo;


public class MainActivity extends ActionBarActivity {

	ListView list_view;
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	int i=0;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = (ListView)findViewById(R.id.mylistview);
        list.add("Arun");
        list.add("suresh");
        list.add("kumar");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,list);
        list_view.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	//AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
    	EditText e;
    	String n;
    	switch(item.getItemId()){
    	case R.id.add_id: e=(EditText)findViewById(R.id.editText1);
    					  n=e.getText().toString();
    					  list.add(n);
    					  Toast.makeText(getApplicationContext(),"Added "+n,Toast.LENGTH_LONG).show();
    					  adapter.notifyDataSetChanged();
    					  return true;
    	case R.id.delete_id:e=(EditText)findViewById(R.id.editText1);
    					    n=e.getText().toString();
    					    if(list.contains(n)){	list.remove(n);	}
    					    else {	Toast.makeText(getApplicationContext(),n+" Not Present",Toast.LENGTH_LONG).show(); }
		  					adapter.notifyDataSetChanged();
    						Toast.makeText(getApplicationContext(),"Deleted "+n,Toast.LENGTH_LONG).show();
    	  					return true;
    	}
    	return false;
    }
}

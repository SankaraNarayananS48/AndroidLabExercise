package com.Exercise2.contextmenuexample;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
	ListView list_view;
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = (ListView)findViewById(R.id.list_view);
        list.add("Arun");
        list.add("suresh");
        list.add("kumar");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        list_view.setAdapter(adapter);
        registerForContextMenu(findViewById(R.id.list_view));
    }
@Override
public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
	super.onCreateContextMenu(menu, v, menuInfo);
	MenuInflater inflater = MainActivity.this.getMenuInflater();
	inflater.inflate(R.menu.main_context_menu,menu);
}
@Override
public boolean onContextItemSelected(MenuItem item){
	AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
	String name = list.get(info.position).toString();
	switch(item.getItemId()){
	case R.id.sms_id: Toast.makeText(getApplicationContext(),"Sending SMS to"+name,Toast.LENGTH_LONG).show();
					  return true;
	case R.id.call_id: 
						Toast.makeText(getApplicationContext(),"Calling "+name,Toast.LENGTH_LONG).show();
	  					return true;
	}
	return false;
}

}

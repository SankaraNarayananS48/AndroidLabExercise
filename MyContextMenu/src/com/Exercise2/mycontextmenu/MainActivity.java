package com.Exercise2.mycontextmenu;

import java.util.List;

import android.support.v7.app.ActionBarActivity;  
import android.os.Bundle;  
import android.view.ContextMenu;  
import android.view.MenuInflater;  
//import android.view.MenuItem;  
import android.view.View;  
import android.widget.ArrayAdapter;  
import android.widget.ListView;  
//import android.widget.Toast;  
import java.util.ArrayList;
  
public class MainActivity extends ActionBarActivity {  
    ListView listView;  
    List<String> contacts=new ArrayList<String>();
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        listView=(ListView)findViewById(R.id.listView);  
        contacts.add("Arun");
        contacts.add("Suresh");
        contacts.add("Kumar");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,contacts);  
        listView.setAdapter(adapter);  
        // Register the ListView  for Context menu  
        registerForContextMenu(listView);  
    }  
    @Override  
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)  
    {  
        super.onCreateContextMenu(menu, v, menuInfo);  
        MenuInflater inflater = getMenuInflater();  
        inflater.inflate(R.menu.main_menu, menu);  
        //menu.setHeaderTitle("Select The Action");  
        //inflater.show();
    }  
    /*@Override  
    public boolean onContextItemSelected(MenuItem item){  
        if(item.getItemId()==R.id.call){  
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();  
        }  
        else if(item.getItemId()==R.id.sms){  
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();  
        }else{  
            return false;  
        }  
        return true;  
    } */ 
}  
package com.Exercise5.bookdb;

import android.support.v7.app.ActionBarActivity;
//import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	EditText bookid,bookauthor,booktitle,bookprice,bookedition;
	Button insert,delete,update,buttonview;
	DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookid=(EditText)findViewById(R.id.bid);
        bookauthor=(EditText)findViewById(R.id.bauthor);
        booktitle=(EditText)findViewById(R.id.btitle);
        bookprice=(EditText)findViewById(R.id.bprice);
        bookedition=(EditText)findViewById(R.id.bedition);
        
        insert=(Button)findViewById(R.id.binsert);
        delete=(Button)findViewById(R.id.bdelete);
        update=(Button)findViewById(R.id.bupdate);
        buttonview=(Button)findViewById(R.id.bview);
        
        db = new DBHelper(this);
        
        
        insert.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View view){
        		String booksid = bookid.getText().toString();
        		String booksauthor = bookauthor.getText().toString();
        		String bookstitle = booktitle.getText().toString();
        		String booksprice = bookprice.getText().toString();
        		String booksedition = bookedition.getText().toString();
        		
        		Boolean checkinsert = db.insertbookdata(booksid, booksauthor, bookstitle, booksprice, booksedition);
        		if(checkinsert==true){
        			Toast.makeText(MainActivity.this, "Inserted Successfully",Toast.LENGTH_LONG).show();
        		}
        		else{
        			Toast.makeText(MainActivity.this, "Not Inserted",Toast.LENGTH_LONG).show();	
        		}
        	}
        });
        
        update.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View view){
        		String booksid = bookid.getText().toString();
        		String booksauthor = bookauthor.getText().toString();
        		String bookstitle = booktitle.getText().toString();
        		String booksprice = bookprice.getText().toString();
        		String booksedition = bookedition.getText().toString();
        		
        		Boolean checkupdate = db.updatebookdata(booksid, booksauthor, bookstitle, booksprice, booksedition);
        		if(checkupdate==true){
        			Toast.makeText(MainActivity.this, "Update Successfully",Toast.LENGTH_LONG).show();
        		}
        		else{
        			Toast.makeText(MainActivity.this, "Not Updated",Toast.LENGTH_LONG).show();	
        		}
        	}
        });
        
        delete.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View view){
        		String booksid = bookid.getText().toString();
        		Boolean checkdelete = db.deletebookdata(booksid);
        		if(checkdelete==true){
        			Toast.makeText(MainActivity.this, "Deleted Successfully",Toast.LENGTH_LONG).show();
        		}
        		else{
        			Toast.makeText(MainActivity.this, "Not Deleted",Toast.LENGTH_LONG).show();	
        		}
        	}
        });
        
        buttonview.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View view){
        		Cursor res = db.getdata();
        		if(res.getCount()==0){
        			Toast.makeText(MainActivity.this, "No entry exist",Toast.LENGTH_LONG).show();
        			return;
        		}
        		StringBuffer buffer = new StringBuffer();
        		while(res.moveToNext()){
        			buffer.append("Bookid:"+res.getString(0)+"\n");
        			buffer.append("BookAuthor:"+res.getString(1)+"\n");
        			buffer.append("BookTitle:"+res.getString(2)+"\n");
        			buffer.append("Bookprice:"+res.getString(3)+"\n");
        			buffer.append("BookEdition:"+res.getString(4)+"\n");
        			buffer.append("\n");
        		}
        		/*AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        		builder.setCancelable(true);
        		builder.setTitle("Book Enteries");
        		builder.setMessage(buffer.toString());
        		builder.show();*/
        		Intent i = new Intent(getApplicationContext(), ViewResult.class);  
                i.putExtra("Result", buffer.toString());   
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

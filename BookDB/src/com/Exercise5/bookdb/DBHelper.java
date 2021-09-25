package com.Exercise5.bookdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	private static final String tablename="Bookdetails";
	private static final String dbname="Bookdb";
	private static final String keyid="bookid";
	private static final String keyauthor="bookauthor";
	private static final String keytitle="booktitle";
	private static final String keyprice="bookprice";
	private static final String keyedition="bookedition";
	
	public DBHelper(Context context) {
		super(context,dbname, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) { 
		sdb.execSQL("CREATE TABLE bookdetails(bookid TEXT PRIMARY KEY,bookauthor TEXT,booktitle TEXT,bookprice TEXT,bookedition TEXT);");
		Log.d("Database operations","Tablecreated");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//String sql = "DROP TABLE IF EXISTS"+tablename;
		db.execSQL("DROP TABLE IF EXISTS bookdetails");
		onCreate(db);
	}
	public Boolean insertbookdata(String id,String author,String title,String price,String edition){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(keyid, id);
		contentValues.put(keyauthor, author);
		contentValues.put(keytitle, title);
		contentValues.put(keyprice, price);
		contentValues.put(keyedition, edition);
		long result=db.insert(tablename, null, contentValues);
		if(result==-1){
			return false;
		}
		else{
			return true;
		}
	}
	public Boolean updatebookdata(String id,String author,String title,String price,String edition){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		//contentValues.put("bookid", id);
		contentValues.put(keyauthor, author);
		contentValues.put(keytitle, title);
		contentValues.put(keyprice, price);
		contentValues.put(keyedition, edition);
		Cursor cursor = db.rawQuery("SELECT * FROM bookdetails WHERE bookid =?",new String[]{id});
		if(cursor.getCount()>0){
			long result=db.update("Bookdetails", contentValues,"bookid=?",new String[]{id});
			if(result==-1){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	public Boolean deletebookdata(String id){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM bookdetails WHERE bookid =?",new String[]{id});
		if(cursor.getCount()>0){
			long result=db.delete("Bookdetails","bookid=?",new String[]{id});
			if(result==-1){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	public Cursor getdata(){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM bookdetails",null);
		return cursor;
		
	}
	

}

package com.example.thandroid_milkteabooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.thandroid_milkteabooking.Adapter.orderAdapter;

public class SQLite  extends SQLiteOpenHelper {


    private Context context;
    public SQLite(Context context, String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME,null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    SQLiteDatabase db = this.getWritableDatabase();
    public void QueryData(String sql)
    {
        db=getWritableDatabase();
        db.execSQL(sql);
    }
    public void Upadatecontacts(String Title,String Image, String Price, String soluong)
    {
        ContentValues values= new ContentValues();
        values.put("Image",Image);
        values.put("Title",Title);
        values.put("Price",Price);
        values.put("soluong",soluong);


        int resurft=db.update("Array",values, "Title = ?", new String[] { Title });
        db.close();
        if(resurft==0)
        {
            //fail
        }
        else
        {
            //success
        }
    }
    public void Deletecontacts(String Title)
    {
        int resurft=db.delete("Array", "ID = ?", new String[] { Title });
        db.close();
        if(resurft==0)
        {
            //fail
        }
        else
        {
            //success
        }
    }
    public void Insertcontacts(String Title, String Image, String Price, String soluong)
    {
        db=getWritableDatabase();
        String sql="Insert into array values (?,?,?,?)";
        SQLiteStatement sqLiteStatement=db.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,Title);
        sqLiteStatement.bindString(2,Image);
        sqLiteStatement.bindString(3,Price);
        sqLiteStatement.bindString(4,soluong);

    }
}
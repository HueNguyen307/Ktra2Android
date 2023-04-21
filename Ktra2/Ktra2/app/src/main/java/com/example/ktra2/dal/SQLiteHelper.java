package com.example.ktra2.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ktra2.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="CongViec.db";
    private static int DATABASE_VERSION = 1;
    public SQLiteHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE if NOT EXISTS items(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT, des TEXT,date TEXT,status TEXT, team BOOLEAN)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    //get all order by giam dan
    public List<Item> getAll(){
        List<Item> list=new ArrayList<>();
        SQLiteDatabase st=getReadableDatabase();
        String order="date DESC";
        Cursor rs=st.query("items",null,null,null,null,null,order);
        while (rs!=null&&rs.moveToNext()){
            int id=rs.getInt(0);
            String title=rs.getString(1);
            String des=rs.getString(2);
            String date=rs.getString(3);
            String status=rs.getString(4);
            boolean team=Boolean.parseBoolean(rs.getString(5));
            list.add(new Item(id,title,des,date,status,team));
        }
        return list;
    }
    public long addItem(Item i){
        ContentValues values = new ContentValues();
        values.put("title", i.getTitle());
        values.put("des", i.getDescription());
        values.put("date", i.getDate());
        values.put("status",i.getStatus());
        values.put("team",i.getTeam());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("items",null, values);

    }
    public int update(Item i){
        ContentValues values=new ContentValues();
        values.put("title", i.getTitle());
        values.put("des", i.getDescription());
        values.put("date", i.getDate());
        values.put("status",i.getStatus());
        values.put("team",i.getTeam());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String whereClause="id =?";
        String [] whereArgs={Integer.toString(i.getId())};
        return sqLiteDatabase.update("items", values,whereClause,whereArgs);
    }
    public int delete(int id){
        String whereClause="id =?";
        String [] whereArgs={Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("items",whereClause,whereArgs);

    }

}

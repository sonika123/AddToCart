package com.sonika.telemartjson.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sonika.telemartjson.Pojo.OrderedProducts_pojo;

import java.util.ArrayList;

/**
 * Created by sonika on 9/23/2017.
 */

public class OrderHelper extends SQLiteOpenHelper {
    static int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "user_order";


    String ORDER_TABLE = "CREATE TABLE if not exists `user_order`  (\n" +
            "                       `id` INTEGER PRIMARY KEY,\n" +
            "                       `name` TEXT,\n" +
            "                       `price` TEXT\n" +
            "                      );";

    public OrderHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(ORDER_TABLE);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertOrderInfo(ContentValues cv) {
        getWritableDatabase().insert("user_order", "", cv);

    }

    public ArrayList<OrderedProducts_pojo> getOrderMessage() {
        String sql = "select * from user_order";
        ArrayList<OrderedProducts_pojo> list = new ArrayList<OrderedProducts_pojo>();
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            OrderedProducts_pojo orderinfo = new OrderedProducts_pojo();
            orderinfo.orderid = cursor.getInt(cursor.getColumnIndex("id"));
            orderinfo.orderedname = cursor.getString(cursor.getColumnIndex("name"));
            orderinfo.orderedprice = cursor.getString(cursor.getColumnIndex("price"));
            list.add(orderinfo);
        }
        cursor.close();
        return list;
    }

    public void delete(Integer id) {
        getWritableDatabase().delete("user_order", "id = ?" +id, new String[] { String.valueOf(id) });
        Log.e("deletinsqlite", "ghijklmnop");
    }

    public void deleteNotif(int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("user_order", "id=" + _id, null);
    }

    public void add(String price)
    {
        getWritableDatabase().execSQL("Select sum(price) from user_order");
    }

}

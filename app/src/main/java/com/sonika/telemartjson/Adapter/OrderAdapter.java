package com.sonika.telemartjson.Adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.telemartjson.Helper.OrderHelper;
import com.sonika.telemartjson.OrderedProducts;
import com.sonika.telemartjson.Pojo.OrderedProducts_pojo;
import com.sonika.telemartjson.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 5/9/2017.
 */

public class OrderAdapter extends ArrayAdapter<OrderedProducts_pojo> {
    Context context;
    List<OrderedProducts_pojo> objects = new ArrayList<OrderedProducts_pojo>();
    OrderedProducts_pojo pojo;
    int resource;
    OrderHelper dbHelper;
    String oid, oprice, oname;


    public OrderAdapter(Context context, int resource, List<OrderedProducts_pojo> objects) {
        super(context, resource, objects);
        Log.e("adapter", "done");
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.orderid = row.findViewById(R.id.ordered_productid);
            holder.name = row.findViewById(R.id.ordered_productname);
            holder.price= row.findViewById(R.id.ordered_productprice);
            holder.btnRemove = row.findViewById(R.id.btn_remove);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final OrderedProducts_pojo orderInfo = objects.get(position);
        dbHelper = new OrderHelper(context);

        holder.orderid.setText(orderInfo.getOrderid().toString());
        holder.name.setText("Name:"+" "+orderInfo.getOrderedname());
        holder.price.setText("Price:" + " "+orderInfo.getOrderedprice());



        oprice = orderInfo.getOrderedprice();
        ContentValues cv = new ContentValues();
        cv.put("price", oprice);

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show();
            }
        });

        //holder.total.setText("Total");



        return row;
    }




    static class ViewHolder {
        TextView name, price, orderid;
        Button btnRemove;
    }
}






package com.sonika.telemartjson.Adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.telemartjson.Helper.OrderHelper;
import com.sonika.telemartjson.OrderedProducts;
import com.sonika.telemartjson.Pojo.OrderedProducts_pojo;
import com.sonika.telemartjson.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by sonika on 5/9/2017.
 */

public class OrderAdapter extends BaseAdapter{


    Context context;
    List<OrderedProducts_pojo> objects = new ArrayList<OrderedProducts_pojo>();
    OrderedProducts_pojo pojo;
    OrderedProducts orderedProducts;
    int resource;
    OrderHelper dbHelper;


    public OrderAdapter(Context contexta, List<OrderedProducts_pojo> objects, int resource) {
        this.context= contexta;
        this.objects = objects;
        this.resource = resource;
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        dbHelper = new OrderHelper(context);
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


        //holder.orderid.setText(orderInfo.getOrderid().toString());

        holder.orderid.setText(position + 1 +" ");
        holder.name.setText("Name:"+" "+orderInfo.getOrderedname());
        holder.price.setText("Price:" + " "+orderInfo.getOrderedprice());
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dbHelper.delete(orderInfo.getOrderid().toString(), null, null);
                dbHelper.delete(objects.get(position).getOrderid()
                        .toString(), null, null);
                Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show();
                objects.remove(position);
                //Log.e("object11", String.valueOf(objects.size()));

                orderedProducts =  new OrderedProducts();
                orderedProducts.getMyTotal();
                notifyDataSetChanged();
            }
        });
        return row;
    }
    static class ViewHolder {
        TextView name, price, orderid;
        Button btnRemove;
    }
}
package com.sonika.telemartjson.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sonika.telemartjson.R;

/**
 * Created by sonika on 9/22/2017.
 */

class OrderedProductHolder  extends RecyclerView.ViewHolder{

    TextView ordered_price, ordered_name;
    public OrderedProductHolder(View itemView) {
        super(itemView);
        ordered_name = itemView.findViewById(R.id.ordered_productname);
        ordered_price = itemView.findViewById(R.id.ordered_productprice);
    }
}

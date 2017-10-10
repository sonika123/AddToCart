package com.sonika.telemartjson.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.telemartjson.R;

/**
 * Created by sonika on 9/19/2017.
 */

public class AllProductHolder extends RecyclerView.ViewHolder {
    public ImageView allproductImage;
    public TextView allproductName;
    public Button addtocart, viewMore;


    public AllProductHolder(View itemView) {
        super(itemView);
        allproductName = itemView.findViewById(R.id.all_product_name);
        allproductImage = itemView.findViewById(R.id.all_product_image);
        addtocart = itemView.findViewById(R.id.addToCart);
        viewMore = itemView.findViewById(R.id.viewMore);

    }
}

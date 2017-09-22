package com.sonika.telemartjson.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sonika.telemartjson.DetailsActivity;
import com.sonika.telemartjson.Pojo.AllProducts;
import com.sonika.telemartjson.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sonika on 9/19/2017.
 */

public class AllProductAdapter extends RecyclerView.Adapter<AllProductHolder>  {
    public Context context;
    private List<AllProducts> allProductList;

    public AllProductAdapter(Context context, List<AllProducts> allproductList) {
        this.context = context;
        this.allProductList = allproductList;
    }
    @Override
    public AllProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.all_productlist, parent, false);

        return new AllProductHolder(view);
    }

    @Override
    public void onBindViewHolder(AllProductHolder allholder, final int position) {
        allholder.allproductName.setText(allProductList.get(position).getName());
        Picasso.with(context).load(allProductList.get(position).getI_src()).into(allholder.allproductImage);
        Log.e("chankhey", "monkey");

        allholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllProducts intentprod = allProductList.get(position);
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("hello", intentprod);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Log.e("sanjeev", String.valueOf(allProductList.size()));
        return allProductList.size();
    }
}

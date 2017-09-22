//package com.sonika.telemartjson.Adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.sonika.telemartjson.Pojo.ProductObject;
//import com.sonika.telemartjson.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//
///**
// * Created by sonika on 8/30/2017.
// */
//
//public class ProductAdapter extends RecyclerView.Adapter<ProductHolder> {
//
//    public Context context;
//    private List<ProductObject> productList;
//
//    public ProductAdapter(Context context, List<ProductObject> productList) {
//        this.context = context;
//        this.productList = productList;
//    }
//
//    @Override
//    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate
//                (R.layout.product_list, parent, false);
//
//        return new ProductHolder(view);
//
//    }
//
//
//    @Override
//    public void onBindViewHolder(ProductHolder holder, int position) {
//
//        holder.productName.setText( productList.get(position).getName());
//
//       Picasso.with(context).load(productList.get(position).getSrc()).into(holder.productImage);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return productList.size();
//    }
//}

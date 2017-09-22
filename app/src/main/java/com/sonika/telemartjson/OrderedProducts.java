package com.sonika.telemartjson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sonika.telemartjson.Adapter.OrderedProductsAdapter;
import com.sonika.telemartjson.Helper.MySharedPreference;
import com.sonika.telemartjson.Pojo.AllProducts;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sonika on 9/22/2017.
 */

public class OrderedProducts extends AppCompatActivity {
    RecyclerView orders_recyclerView;
    List<AllProducts> allProductList = new ArrayList<AllProducts>();
    //AllProducts allProducts = new AllProducts();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordered_products);
        for (int i = 0; i< allProductList.size(); i++) {
            String name = allProductList.get(i).getName();
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        }

        orders_recyclerView = (RecyclerView) findViewById(R.id.ordered_products);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderedProducts.this);
        orders_recyclerView.setLayoutManager(linearLayoutManager);
        orders_recyclerView.setHasFixedSize(true);
//adding to cart

        MySharedPreference mShared = new MySharedPreference(OrderedProducts.this);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        AllProducts[] addCartProducts = gson.fromJson(mShared.retrieveProductFromCart(), AllProducts[].class);
        List<AllProducts> productList1 = convertObjectArrayToListObject(addCartProducts);

        OrderedProductsAdapter mAdapter = new OrderedProductsAdapter(OrderedProducts.this,productList1);
        orders_recyclerView.setAdapter(mAdapter);



    }

    private List<AllProducts> convertObjectArrayToListObject(AllProducts[] allProducts){
        final AllProducts allProductsa = (AllProducts) getIntent().getSerializableExtra("hello");
        List<AllProducts> mProduct = new ArrayList<AllProducts>();
        Collections.addAll(mProduct, allProductsa);
        return mProduct;
   }
}

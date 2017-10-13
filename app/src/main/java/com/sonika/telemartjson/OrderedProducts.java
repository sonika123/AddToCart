package com.sonika.telemartjson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.telemartjson.Adapter.OrderAdapter;
;

import com.sonika.telemartjson.Helper.OrderHelper;
import com.sonika.telemartjson.Pojo.OrderedProducts_pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 9/22/2017.
 */

public class OrderedProducts extends AppCompatActivity {
    //RecyclerView orders_recyclerView;
    ListView lv;
    OrderHelper dbhelper;
    OrderedProducts_pojo orderedProducts;
    List<OrderedProducts_pojo> orderedProductsList = new ArrayList<>();
    TextView totalAmount;
    Context mcontext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordered_products);
        lv = (ListView) findViewById(R.id.ordererd_productList);
        totalAmount = (TextView) findViewById(R.id.totalamount);
        mcontext = this.getApplicationContext();
        getMyTotal();
        show();
    }

    public void show() {
        final ArrayList<OrderedProducts_pojo> list = dbhelper.getOrderMessage();
        for (int i = 0; i < list.size(); i++) {
            final OrderedProducts_pojo info = list.get(i);
            final OrderAdapter notifyAdapter = new OrderAdapter(OrderedProducts.this, list, R.layout.ordered_products_list);
            lv.setAdapter(notifyAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }

    public void getMyTotal() {

        dbhelper = new OrderHelper(OrderedProducts.this);
        OrderAdapter adapter = new OrderAdapter(mcontext, orderedProductsList, R.layout.ordered_products_list);

        Cursor Distance = dbhelper.GetTotal();
        adapter.getItem(Distance.getColumnIndex("myTotal"));

        adapter.notifyDataSetChanged();

        String result = "";


        // get column value
        while (Distance.moveToNext()) {
            result = String.valueOf(Distance.getDouble(Distance.getColumnIndex("myTotal")));
            totalAmount.setText("Your total bill amount is " + result);
        }

    }

}

//        orders_recyclerView = (RecyclerView) findViewById(R.id.or);
//        //Toast.makeText(this, orderedProducts.getOrderedname(), Toast.LENGTH_SHORT).show();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderedProducts.this);
//        orders_recyclerView.setLayoutManager(linearLayoutManager);
//        orders_recyclerView.setHasFixedSize(true);
//        OrderedProductsAdapter orderAdapter = new OrderedProductsAdapter
//                (getApplicationContext(), orderedProductsList);
//        orders_recyclerView.setAdapter(orderAdapter);




      //  Toast.makeText(this, allProducts.getName(), Toast.LENGTH_SHORT).show();

//adding to cart

//        MySharedPreference mShared = new MySharedPreference(OrderedProducts_pojo.this);
//
//        GsonBuilder builder = new GsonBuilder();
//        Gson gson = builder.create();
//        AllProducts[] addCartProducts = gson.fromJson(mShared.retrieveProductFromCart(), AllProducts[].class);
//        List<AllProducts> productList = convertObjectArrayToListObject(addCartProducts);

//        OrderedProductsAdapter mAdapter = new OrderedProductsAdapter(getApplicationContext(), productList);
//        orders_recyclerView.setAdapter(mAdapter);
//    }
//
//    private List<AllProducts> convertObjectArrayToListObject(AllProducts[] allProducts){
//       // final AllProducts allProductsa = (AllProducts) getIntent().getSerializableExtra("hello");
//        //List<AllProducts> mProduct = new ArrayList<AllProducts>();
//        AllProducts mProduct =(AllProducts) getIntent().getSerializableExtra("hello");
//        allProductList.add(mProduct);
//        Collections.addAll(allProductList, allProducts);
//        return allProductList;
//   }
//}

//package com.sonika.telemartjson;
//
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.sonika.telemartjson.Adapter.ProductAdapter;
//import com.sonika.telemartjson.Parser.JsonParserA;
//import com.sonika.telemartjson.Pojo.ProductObject;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//
//public class MainActivityFragment extends Fragment {
//    int flag = 0;
//
//    RecyclerView bestRecyclerView;
//    List<ProductObject> ProductList = new ArrayList<ProductObject>();
//
//    public MainActivityFragment() {
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_main, container, false);
//        perform(v);
//        return v;
//    }
//
//    public void perform(View v) {
//        new ProductAsyncTask().execute();
//    }
//
//    class ProductAsyncTask extends AsyncTask<String, String, String> {
//        ProgressDialog mprogressDialog;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            mprogressDialog = new ProgressDialog(getContext());
//            mprogressDialog.setMessage("Please wait");
//            mprogressDialog.setCancelable(false);
//            mprogressDialog.show();
//
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            HashMap<String, String> loginHashMap = new HashMap<>();
//            JsonParserA jsonParser = new JsonParserA();
//            JSONObject jsonObject = jsonParser.performPostCI
//                    ("https://nepstra.com/api/android/categories.php", loginHashMap);
//            try {
//                if (jsonObject == null) {
//                    flag = 1;
//                } else {
//                    if (jsonObject.getString("status").equals("success")) {
//                        JSONArray jsonArray = jsonObject.getJSONArray("data");
//                        for (int i = 0; i < jsonArray.length(); i++) {
//
//                            JSONObject dataObject = jsonArray.getJSONObject(i);
//                            Integer ids = dataObject.getInt("id");
//                            String name = dataObject.getString("name");
//                            String slug = dataObject.getString("slug");
//                            Integer parent = dataObject.getInt("parent");
//                            String description = dataObject.getString("description");
//                            String display = dataObject.getString("display");
//
//                            JSONObject imageObject = dataObject.getJSONObject("image");
//
//                            Integer image_id = imageObject.getInt("id");
//                            String date_created = imageObject.getString("date_created");
//                            String date_created_gmt = imageObject.getString("date_created_gmt");
//                            String date_modified = imageObject.getString("date_modified");
//                            String date_modified_gmt = imageObject.getString("date_modified_gmt");
//                            String src = imageObject.getString("src");
//                            String title = imageObject.getString("title");
//                            String alt = imageObject.getString("alt");
//
//                            Integer menu_order = dataObject.getInt("menu_order");
//                            Integer count = dataObject.getInt("count");
//
//                            JSONObject _links = dataObject.getJSONObject("_links");
//
//                            JSONArray self_array = _links.getJSONArray("self");
//                            // for (int j = 0; j < self_array.length(); j++) {
//                            String href = self_array.getJSONObject(0).getString("href");
//                            // }
//                            JSONArray collection_array = _links.getJSONArray("collection");
//
//                            // for (int k = 0; k < collection_array.length(); k++) {
//                            String collection = collection_array.getJSONObject(0).getString("href");
//                            // }
//
//                            ProductObject productObject = new ProductObject(ids, count, menu_order, parent, image_id, name, slug, description, display, alt, date_created, date_modified_gmt, date_created_gmt,
//                                    date_modified, src, title, href, collection);
//                            ProductList.add(productObject);
//                            flag = 2;
//
//                        }
//                    } else {
//                        flag = 3;
//                    }
//                }
//
//
//            } catch (JSONException e) {
//
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            mprogressDialog.dismiss();
//            if (flag == 1) {
//                Toast.makeText(getContext(), "Server/Network issue", Toast.LENGTH_SHORT).show();
//
//            } else if (flag == 2) {
//                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
//                bestRecyclerView = (RecyclerView) getView().findViewById(R.id.product_list);
//                GridLayoutManager mGrid = new GridLayoutManager(getContext(), 2);
//                bestRecyclerView.setLayoutManager(mGrid);
//                bestRecyclerView.setHasFixedSize(true);
//                bestRecyclerView.setNestedScrollingEnabled(false);
//
//                ProductAdapter mAdapter = new ProductAdapter(getContext(), ProductList);
//                bestRecyclerView.setAdapter(mAdapter);
//                return;
//
//            } else {
//                Toast.makeText(getContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}
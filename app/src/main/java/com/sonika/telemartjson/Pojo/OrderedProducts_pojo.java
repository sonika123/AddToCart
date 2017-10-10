package com.sonika.telemartjson.Pojo;

/**
 * Created by sonika on 9/23/2017.
 */

public class OrderedProducts_pojo {
    public String orderedname, orderedprice;
    public  Integer orderid;

    public OrderedProducts_pojo() {
    }

    public OrderedProducts_pojo(Integer orderid, String orderedname, String orderedprice) {
        this.orderid = orderid;
        this.orderedname = orderedname;
        this.orderedprice = orderedprice;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid)
    {
        this.orderid = orderid;
    }

    public String getOrderedname() {
        return orderedname;
    }

    public void setOrderedname(String orderedname) {
        this.orderedname = orderedname;
    }

    public String getOrderedprice() {
        return orderedprice;
    }

    public void setOrderedprice(String orderedprice) {
        this.orderedprice = orderedprice;
    }
}


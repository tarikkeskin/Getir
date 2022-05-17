package com.example.getirdesign.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductCevap {
    @SerializedName("yemekler")
    @Expose
    private List<Products> products;
    @SerializedName("success")
    @Expose
    private int success;

    public ProductCevap() {
    }

    public ProductCevap(List<Products> products, int success) {
        this.products = products;
        this.success = success;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}

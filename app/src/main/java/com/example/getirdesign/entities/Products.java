package com.example.getirdesign.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Products implements Serializable {
    @SerializedName("yemek_id")
    @Expose
    private int productId;
    @SerializedName("yemek_adi")
    @Expose
    private String productName;
    @SerializedName("yemek_resim_adi")
    @Expose
    private String productImage;
    @SerializedName("yemek_fiyat")
    @Expose
    private double productPrice;


    public Products() {
    }

    public Products(int productId, String productName, String productImage, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}

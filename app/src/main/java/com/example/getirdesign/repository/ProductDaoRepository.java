package com.example.getirdesign.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.getirdesign.entities.CRUDCevap;
import com.example.getirdesign.entities.CartProductsCevap;
import com.example.getirdesign.entities.Category;
import com.example.getirdesign.entities.ProductCevap;
import com.example.getirdesign.entities.Products;
import com.example.getirdesign.entities.SepetYemekler;
import com.example.getirdesign.entities.SubCategory;
import com.example.getirdesign.retrofit.ApiUtils;
import com.example.getirdesign.retrofit.ProductDaoInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDaoRepository {
    private MutableLiveData<List<Products>> productsList;
    private MutableLiveData<List<SepetYemekler>> cartProductsList;
    private ProductDaoInterface productDaoInterface;

    public ProductDaoRepository() {
        productDaoInterface = ApiUtils.getProductDaoInterface();
        productsList = new MutableLiveData<>();
        cartProductsList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Products>> returnAllProductsRepo(){
        return productsList;
    }

    public MutableLiveData<List<SepetYemekler>> returnAllCartProductsRepo(){
        return cartProductsList;
    }

    public void addProductRepo(String product_name, String product_image , int product_price , int product_amount,String user_name){
        productDaoInterface.addProductToCart(product_name,product_image,product_price,product_amount,user_name).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) { }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) { }
        });

    }

    public void getAllProductsRepo(){
        productDaoInterface.allProducts().enqueue(new Callback<ProductCevap>() {
            @Override
            public void onResponse(Call<ProductCevap> call, Response<ProductCevap> response) {
                List<Products> list = response.body().getProducts();
                productsList.setValue(list);
            }
            @Override
            public void onFailure(Call<ProductCevap> call, Throwable t) {}
        });
    }

    public void getCartProductsRepo(String user_name){

        productDaoInterface.getCartProducts(user_name).enqueue(new Callback<CartProductsCevap>() {
            @Override
            public void onResponse(Call<CartProductsCevap> call, Response<CartProductsCevap> response) {
                List<SepetYemekler> list = response.body().getSepetYemekler();
                cartProductsList.setValue(list);
            }

            @Override
            public void onFailure(Call<CartProductsCevap> call, Throwable t) { }
        });
    }

    public void removeProductFromCartRepo(int product_id,String user_name){
        productDaoInterface.removeProductFromCart(product_id,user_name).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) { }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) { }
        });
    }

}

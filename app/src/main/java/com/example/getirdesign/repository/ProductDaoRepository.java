package com.example.getirdesign.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.getirdesign.entities.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoRepository {
    private MutableLiveData<List<Products>> productsList;

    public ProductDaoRepository() {
        productsList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Products>> returnAllProductsRepo(){
        return productsList;
    }

    public void addProductRepo(int product_id){
        Log.e("Product","->"+product_id);
    }

    public void getAllProductsRepo(){
        ArrayList<Products> productsArrayListTemp = new ArrayList<>();
        Products p1 = new Products(1,"Lay's Sarımsak & Soğan","cips1",3.89,150);
        Products p2 = new Products(2,"Lay's Bal Barbekü","cips2",4.99,165);
        Products p3 = new Products(3,"Lay's Klasik Dalgalı Aile Boyu","cips3",6.99,210);
        Products p4 = new Products(4,"Pringles Klasik","cips4",2.90,165);
        Products p5 = new Products(5,"Pringles Texas BBQ Sos","cips5",3.59,165);
        Products p6 = new Products(6,"Pringles Jalapeno Biberi","cips6",3.59,165);
        Products p7 = new Products(7,"Doritos Nacho Peynirli","cips7",3.89,113);
        Products p8 = new Products(8,"Ruffles Klasik","cips8",2.30,150);
        Products p9 = new Products(9,"Cheetos Puffs","cips9",1.99,41);
        Products p10 = new Products(10,"Doritos Original Tuzlu","cips10",3.89,113);
        Products p11 = new Products(11,"Cheetos Dana Etli & Soğanlı","cips11",1.99,41);
        productsArrayListTemp.add(p1);
        productsArrayListTemp.add(p2);
        productsArrayListTemp.add(p3);
        productsArrayListTemp.add(p4);
        productsArrayListTemp.add(p5);
        productsArrayListTemp.add(p6);
        productsArrayListTemp.add(p7);
        productsArrayListTemp.add(p8);
        productsArrayListTemp.add(p9);
        productsArrayListTemp.add(p10);
        productsArrayListTemp.add(p11);
        productsList.setValue(productsArrayListTemp);
    }
}

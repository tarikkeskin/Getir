package com.example.getirdesign.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.getirdesign.entities.Products;
import com.example.getirdesign.repository.ProductDaoRepository;

import java.util.List;

public class HomePageFragmentViewModel extends ViewModel {
    private ProductDaoRepository productDaoRepository = new ProductDaoRepository();
    public MutableLiveData<List<Products>> productsList = new MutableLiveData<>();

    public HomePageFragmentViewModel() {
        getAllProducts();
        productsList = productDaoRepository.returnAllProductsRepo();
    }

    public void add(int product_id){
        productDaoRepository.addProductRepo(product_id);
    }

    public void getAllProducts(){
        productDaoRepository.getAllProductsRepo();
    }

}

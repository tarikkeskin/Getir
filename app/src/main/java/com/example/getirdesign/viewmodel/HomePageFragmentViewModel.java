package com.example.getirdesign.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.getirdesign.entities.Category;
import com.example.getirdesign.entities.Products;
import com.example.getirdesign.entities.SubCategory;
import com.example.getirdesign.repository.CategoryDaoRepository;
import com.example.getirdesign.repository.ProductDaoRepository;
import com.example.getirdesign.repository.SubCategoryDaoRepository;

import java.util.List;

public class HomePageFragmentViewModel extends ViewModel {
    private final ProductDaoRepository productDaoRepository = new ProductDaoRepository();
    private final CategoryDaoRepository categoryDaoRepository = new CategoryDaoRepository();
    private final SubCategoryDaoRepository subCategoryDaoRepository = new SubCategoryDaoRepository();

    public MutableLiveData<List<Products>> productsList;
    public MutableLiveData<List<Category>> categoryList;
    public MutableLiveData<List<SubCategory>> subCategoryList;

    public HomePageFragmentViewModel() {
        getAllProducts();
        getAllCategory();
        getAllSubCategory();
        productsList = productDaoRepository.returnAllProductsRepo();
        categoryList = categoryDaoRepository.returnAllCategoryRepo();
        subCategoryList = subCategoryDaoRepository.returnAllSubCategoryRepo();
    }

    public void add(String product_name, String product_image , int product_price , int product_amount,String user_name){
        productDaoRepository.addProductRepo(product_name,product_image,product_price,product_amount,user_name);
    }

    public void getAllProducts(){
        productDaoRepository.getAllProductsRepo();
    }

    public void getAllCategory(){
        categoryDaoRepository.getAllCategoryRepo();
    }

    public void getAllSubCategory(){
        subCategoryDaoRepository.getAllSubCategoryRepo();
    }

}

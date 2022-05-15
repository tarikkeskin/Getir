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
    private ProductDaoRepository productDaoRepository = new ProductDaoRepository();
    private CategoryDaoRepository categoryDaoRepository = new CategoryDaoRepository();
    private SubCategoryDaoRepository subCategoryDaoRepository = new SubCategoryDaoRepository();

    public MutableLiveData<List<Products>> productsList = new MutableLiveData<>();
    public MutableLiveData<List<Category>> categoryList = new MutableLiveData<>();
    public MutableLiveData<List<SubCategory>> subCategoryList = new MutableLiveData<>();

    public HomePageFragmentViewModel() {
        getAllProducts();
        getAllCategory();
        getAllSubCategory();
        productsList = productDaoRepository.returnAllProductsRepo();
        categoryList = categoryDaoRepository.returnAllCategoryRepo();
        subCategoryList = subCategoryDaoRepository.returnAllSubCategoryRepo();
    }

    public void add(int product_id){
        productDaoRepository.addProductRepo(product_id);
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

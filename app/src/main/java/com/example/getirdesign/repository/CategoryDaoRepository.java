package com.example.getirdesign.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.getirdesign.entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoRepository {
    private MutableLiveData<List<Category>> categoryList;

    public CategoryDaoRepository() {
        this.categoryList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Category>> returnAllCategoryRepo(){
        return categoryList;
    }

    public void getAllCategoryRepo(){
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        Category c1 = new Category(1,"Yeni Ürünler");
        Category c2 = new Category(2,"İndirimler");
        Category c3 = new Category(3,"Su & İçecek");
        Category c4 = new Category(4,"Meyve & Sebze");
        Category c5 = new Category(5,"Fırından");
        Category c6 = new Category(6,"Temel Gıda");
        Category c7 = new Category(7,"Atıştırmalık");
        Category c8 = new Category(8,"Dondurma");
        Category c9 = new Category(9,"Kahvaltılık");
        Category c10 = new Category(10,"Yiyecek");
        categoryArrayList.add(c1);
        categoryArrayList.add(c2);
        categoryArrayList.add(c3);
        categoryArrayList.add(c4);
        categoryArrayList.add(c5);
        categoryArrayList.add(c6);
        categoryArrayList.add(c7);
        categoryArrayList.add(c8);
        categoryArrayList.add(c9);
        categoryArrayList.add(c10);

        categoryList.setValue(categoryArrayList);
    }
}

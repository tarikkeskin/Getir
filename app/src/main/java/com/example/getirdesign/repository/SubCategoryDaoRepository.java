package com.example.getirdesign.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.getirdesign.entities.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryDaoRepository {
    private MutableLiveData<List<SubCategory>> subCategoryList;

    public SubCategoryDaoRepository() {
        this.subCategoryList = new MutableLiveData<>();
    }

    public MutableLiveData<List<SubCategory>> returnAllSubCategoryRepo(){
        return subCategoryList;
    }

    public void getAllSubCategoryRepo(){
        ArrayList<SubCategory> subCategoryArrayList = new ArrayList<>();
        SubCategory s1 = new SubCategory(1,"Birlikte İyi Gider");
        SubCategory s2 = new SubCategory(2,"Cips");
        SubCategory s3 = new SubCategory(3,"Kurutemiş");
        SubCategory s4 = new SubCategory(4,"Tablet Çikolata");
        SubCategory s5 = new SubCategory(5,"Çikolata Bar");
        SubCategory s6 = new SubCategory(6,"Fit Bar");
        SubCategory s7 = new SubCategory(7,"Kek & Bisküvi");
        SubCategory s8 = new SubCategory(8,"Kraker & Kurabiye");
        subCategoryArrayList.add(s1);
        subCategoryArrayList.add(s2);
        subCategoryArrayList.add(s3);
        subCategoryArrayList.add(s4);
        subCategoryArrayList.add(s5);
        subCategoryArrayList.add(s6);
        subCategoryArrayList.add(s7);
        subCategoryArrayList.add(s8);

        subCategoryList.setValue(subCategoryArrayList);
    }
}

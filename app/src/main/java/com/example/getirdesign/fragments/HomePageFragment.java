package com.example.getirdesign.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getirdesign.Products.Category;
import com.example.getirdesign.Products.Products;
import com.example.getirdesign.Products.SubCategory;
import com.example.getirdesign.R;
import com.example.getirdesign.adapters.CategoryAdapter;
import com.example.getirdesign.adapters.ProductsAdapter;
import com.example.getirdesign.adapters.SubCategoryAdapter;
import com.example.getirdesign.databinding.FragmentHomePageBinding;

import java.util.ArrayList;


public class HomePageFragment extends Fragment {

    private FragmentHomePageBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        tasarim = FragmentHomePageBinding.inflate(inflater, container, false);


        /**
         * Products Recycler view
         */

        tasarim.recyclerViewProduct.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        ArrayList<Products> productsArrayList = fillTheProducts();

        ProductsAdapter adapterProduct = new ProductsAdapter(requireContext(),productsArrayList);
        tasarim.recyclerViewProduct.setAdapter(adapterProduct);

        /**
         * Categories Recycler view
         */

        tasarim.recyclerViewCategori.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        ArrayList<Category> categoryArrayList = fillCategories();

        CategoryAdapter adapterCategory = new CategoryAdapter(requireContext(),categoryArrayList);
        tasarim.recyclerViewCategori.setAdapter(adapterCategory);

        /**
         * SubCategories Recycler view
         */

        tasarim.recyclerViewAltCategori.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        ArrayList<SubCategory> subCategoryArrayList = fillSubCategories();

        SubCategoryAdapter adapterSubCategory = new SubCategoryAdapter(requireContext(),subCategoryArrayList);
        tasarim.recyclerViewAltCategori.setAdapter(adapterSubCategory);






        return tasarim.getRoot();
    }





    public ArrayList<Products> fillTheProducts(){
        ArrayList<Products> productsArrayListTemp = new ArrayList<>();
        Products p1 = new Products(1,"Lay's Garlic Sauce","cips1",3.89,150);
        Products p2 = new Products(2,"Lay's Honey Barbecue","cips2",4.99,165);
        Products p3 = new Products(3,"Lay's Original Wavy Family Size","cips3",6.99,150);
        Products p4 = new Products(4,"Pringles Original","cips4",2.90,165);
        Products p5 = new Products(5,"Pringles Texas BBQ Sauce","cips5",3.59,165);
        Products p6 = new Products(6,"Pringles Jalapeno","cips6",3.59,165);
        Products p7 = new Products(7,"Doritos Nacho Cheese","cips7",3.89,113);
        Products p8 = new Products(8,"Ruffles Original","cips8",2.30,150);
        Products p9 = new Products(9,"Cheetos Puffs","cips9",1.99,41);
        Products p10 = new Products(10,"Doritos Original Salted","cips10",3.89,113);
        Products p11 = new Products(11,"Cheetos Beef and Onion","cips11",1.99,41);
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
        return  productsArrayListTemp;
    }

    public ArrayList<Category> fillCategories(){
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
        return categoryArrayList;

    }

    public ArrayList<SubCategory> fillSubCategories(){
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
        return subCategoryArrayList;
    }
}
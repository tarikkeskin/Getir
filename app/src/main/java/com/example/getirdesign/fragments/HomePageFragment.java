package com.example.getirdesign.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getirdesign.R;
import com.example.getirdesign.entities.Category;
import com.example.getirdesign.entities.Products;
import com.example.getirdesign.entities.SubCategory;
import com.example.getirdesign.adapters.CategoryAdapter;
import com.example.getirdesign.adapters.ProductsAdapter;
import com.example.getirdesign.adapters.SubCategoryAdapter;
import com.example.getirdesign.databinding.FragmentHomePageBinding;
import com.example.getirdesign.viewmodel.HomePageFragmentViewModel;

import java.util.ArrayList;


public class HomePageFragment extends Fragment {

    private FragmentHomePageBinding tasarim;
    private HomePageFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page,container, false);


        /*
         * Products Recycler view
         */
        viewModel.productsList.observe(getViewLifecycleOwner(),list -> {
            ProductsAdapter adapterProduct = new ProductsAdapter(requireContext(),list,viewModel);
            tasarim.setProductsAdapter(adapterProduct);
        });


        /*
         * Categories Recycler view
         */
        ArrayList<Category> categoryArrayList = fillCategories();

        CategoryAdapter adapterCategory = new CategoryAdapter(requireContext(),categoryArrayList);
        tasarim.setCategotyAdapter(adapterCategory);

        /*
         * SubCategories Recycler view
         */
        ArrayList<SubCategory> subCategoryArrayList = fillSubCategories();

        SubCategoryAdapter adapterSubCategory = new SubCategoryAdapter(requireContext(),subCategoryArrayList);
        tasarim.setSubCategoryAdapter(adapterSubCategory);

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomePageFragmentViewModel.class);
    }

    public void buttonAdd(int product_id){
        viewModel.add(product_id);
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
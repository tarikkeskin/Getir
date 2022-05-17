package com.example.getirdesign.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


public class HomePageFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentHomePageBinding tasarim;
    private HomePageFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page,container, false);

        ((AppCompatActivity)getActivity()).setSupportActionBar(tasarim.toolbarHomePage);



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
        viewModel.categoryList.observe(getViewLifecycleOwner(),list -> {
            CategoryAdapter adapterCategory = new CategoryAdapter(requireContext(),list);
            tasarim.setCategotyAdapter(adapterCategory);
        });


        /*
         * SubCategories Recycler view
         */
        viewModel.subCategoryList.observe(getViewLifecycleOwner(),list -> {
            SubCategoryAdapter adapterSubCategory = new SubCategoryAdapter(requireContext(),list);
            tasarim.setSubCategoryAdapter(adapterSubCategory);
        });


        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        viewModel = new ViewModelProvider(this).get(HomePageFragmentViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_mainpage,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        search(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        search(newText);
        return true;
    }

    public void search(String searchText){
        Log.e("Product",searchText);
    }
}
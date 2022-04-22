package com.example.getirdesign.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getirdesign.Products.Products;
import com.example.getirdesign.R;
import com.example.getirdesign.adapters.ProductsAdapter;
import com.example.getirdesign.databinding.FragmentHomePageBinding;

import java.util.ArrayList;


public class HomePageFragment extends Fragment {

    private FragmentHomePageBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        tasarim = FragmentHomePageBinding.inflate(inflater, container, false);

        tasarim.toolbarHomePage.setTitle("Products");
        tasarim.recyclerViewProduct.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        ArrayList<Products> productsArrayList = new ArrayList<>();
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
        productsArrayList.add(p1);
        productsArrayList.add(p2);
        productsArrayList.add(p3);
        productsArrayList.add(p4);
        productsArrayList.add(p5);
        productsArrayList.add(p6);
        productsArrayList.add(p7);
        productsArrayList.add(p8);
        productsArrayList.add(p9);
        productsArrayList.add(p10);
        productsArrayList.add(p11);

        ProductsAdapter adapter = new ProductsAdapter(requireContext(),productsArrayList);
        tasarim.recyclerViewProduct.setAdapter(adapter);

        return tasarim.getRoot();
    }
}
package com.example.getirdesign.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.getirdesign.R;
import com.example.getirdesign.adapters.DetailProductAdapter;
import com.example.getirdesign.adapters.ProductsAdapter;
import com.example.getirdesign.databinding.FragmentDetailProductBinding;
import com.example.getirdesign.entities.Products;
import com.example.getirdesign.entities.SepetYemekler;
import com.example.getirdesign.features.OpenDialogAddProduct;
import com.example.getirdesign.viewmodel.HomePageFragmentViewModel;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import dev.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog;


public class DetailProduct extends Fragment {
    private FragmentDetailProductBinding binding;
    private HomePageFragmentViewModel viewModelHomepage;
    private MainPageFragmentViewModel viewModelCart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailProductBinding.inflate(inflater, container, false);

        DetailProductArgs bundle = DetailProductArgs.fromBundle(getArguments());
        Products product = bundle.getProduct();

        binding.setDetayObject(this);
        binding.setProduct(product);



        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+product.getProductImage();
        Picasso.get().load(url).into(binding.imageViewDetailProductImage);

        /*
         * Products Recycler view
         */
        viewModelHomepage.productsList.observe(getViewLifecycleOwner(),list -> {
            DetailProductAdapter adapterProduct = new DetailProductAdapter(requireContext(),list,viewModelHomepage,viewModelCart);
            binding.rvDetailProduct.setAdapter(adapterProduct);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelHomepage = new ViewModelProvider(requireActivity()).get(HomePageFragmentViewModel.class);
        viewModelCart = new ViewModelProvider(requireActivity()).get(MainPageFragmentViewModel.class);
    }

    public void buttonSepeteEkle(Products product){
        OpenDialogAddProduct addDialog = new OpenDialogAddProduct();
        addDialog.openDialog(product,viewModelCart,viewModelHomepage,getActivity());
    }

    public void imageViewBackButton(){
        requireActivity().onBackPressed();
    }


}
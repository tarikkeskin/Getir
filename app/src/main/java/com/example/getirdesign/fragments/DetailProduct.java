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


        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+product.getProductImage();
        Picasso.get().load(url).into(binding.imageViewDetailProductImage);
        binding.textViewDetailProductName.setText(product.getProductName());
        binding.textViewDetailProductFiyat.setText(String.valueOf(product.getProductPrice()));
        binding.textViewDetailProductAdet.setText("1 porsiyon");

        /*
         * Products Recycler view
         */
        viewModelHomepage.productsList.observe(getViewLifecycleOwner(),list -> {
            DetailProductAdapter adapterProduct = new DetailProductAdapter(requireContext(),list,viewModelHomepage,viewModelCart);
            binding.rvDetailProduct.setAdapter(adapterProduct);
        });

        binding.iVBackButtonDetay.setOnClickListener(view -> {
            requireActivity().onBackPressed();
        });

        binding.buttonSepeteEkleDetay.setOnClickListener(view -> {
            openDialog(product);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelHomepage = new ViewModelProvider(requireActivity()).get(HomePageFragmentViewModel.class);
        viewModelCart = new ViewModelProvider(requireActivity()).get(MainPageFragmentViewModel.class);
    }

    /**
     * This will construct An {@link AlertDialog} with some custom views.
     */
    private void openDialog(Products product) {
        //Inflating a LinearLayout dynamically to add TextInputLayout
        //This will be added in AlertDialog
        final LinearLayout linearLayout = (LinearLayout) (getActivity()).getLayoutInflater().inflate(R.layout.view_number_dialog, null);
        NumberPicker numberpicker = (NumberPicker) linearLayout.findViewById(R.id.numberPicker1);


        numberpicker.setMinValue(1);
        numberpicker.setMaxValue(20);
        numberpicker.setValue(1);

        //Finally building an AlertDialog
        final AlertDialog builder = new AlertDialog.Builder(getActivity())
                .setPositiveButton("Ekle", null)
                .setNegativeButton("İptal", null)
                .setView(linearLayout)
                .setCancelable(false)
                .create();
        builder.setCanceledOnTouchOutside(true);
        builder.show();
        //Setting up OnClickListener on positive button of AlertDialog
        builder.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetMaterialDialog mBottomSheetDialog = new BottomSheetMaterialDialog.Builder(getActivity())
                        .setCancelable(false)
                        .setAnimation(R.raw.add_to_cart_animation)
                        .build();
                // Show Dialog
                mBottomSheetDialog.show();

                new Handler().postDelayed(() -> mBottomSheetDialog.dismiss(),5000);

                boolean flag = true;
                int temp_adet = 0;
                String temp_id = null;

                try {
                    List<SepetYemekler> sepetYemeklerList = viewModelCart.cartProductsList.getValue();

                    for (int i = 0; i < sepetYemeklerList.size(); i++) {
                        if (Objects.equals(sepetYemeklerList.get(i).getYemekAdi(), product.getProductName())) {
                            flag = false;
                            temp_adet = Integer.parseInt(sepetYemeklerList.get(i).getYemekSiparisAdet());
                            temp_id = sepetYemeklerList.get(i).getSepetYemekId();
                        }

                    }
                }
                catch (NullPointerException e){
                    Log.e("Product",e.toString());
                }

                if(flag){
                    viewModelHomepage.add(product.getProductName(),
                            product.getProductImage(),
                            (int) product.getProductPrice(),
                            numberpicker.getValue(),
                            "tarik");

                }else{
                    viewModelCart.removeProductFromCart(Integer.parseInt(temp_id),"tarik");
                    viewModelCart.getAllCartProducts();
                    viewModelHomepage.add(product.getProductName(),
                            product.getProductImage(),
                            (int) product.getProductPrice(),
                            numberpicker.getValue()+temp_adet,
                            "tarik");
                }

                builder.cancel();
            }
        });
    }



}
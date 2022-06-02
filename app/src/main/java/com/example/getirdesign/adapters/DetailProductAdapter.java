package com.example.getirdesign.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getirdesign.R;
import com.example.getirdesign.databinding.CardDetailProductsBinding;
import com.example.getirdesign.entities.Products;
import com.example.getirdesign.databinding.CardProductDesingBinding;
import com.example.getirdesign.entities.SepetYemekler;
import com.example.getirdesign.features.OpenDialogAddProduct;
import com.example.getirdesign.fragments.HomePageFragmentDirections;
import com.example.getirdesign.viewmodel.HomePageFragmentViewModel;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import dev.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog;

public class DetailProductAdapter extends RecyclerView.Adapter<DetailProductAdapter.CardDesignAttachment> {
    private Context mContext;
    private List<Products> productsList;
    private HomePageFragmentViewModel viewModel;
    private MainPageFragmentViewModel viewModelCart;

    public DetailProductAdapter(Context mContext, List<Products> productsList, HomePageFragmentViewModel viewModel,MainPageFragmentViewModel viewModelCart) {
        this.mContext = mContext;
        this.productsList = productsList;
        this.viewModel = viewModel;
        this.viewModelCart = viewModelCart;
    }

    public class CardDesignAttachment extends RecyclerView.ViewHolder{
        private CardDetailProductsBinding tasarim;

        public CardDesignAttachment(CardDetailProductsBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardDesignAttachment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardDetailProductsBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_detail_products,parent,false);
        return new CardDesignAttachment(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignAttachment holder, int position) {
        Products product = productsList.get(position);
        CardDetailProductsBinding t = holder.tasarim;

        t.setProductObject(product);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+product.getProductImage();
        Picasso.get().load(url).into(t.imageViewProductDetail);

        t.CardViewAddCartDetail.setOnClickListener(view -> {
            OpenDialogAddProduct addDialog = new OpenDialogAddProduct();
            addDialog.openDialog(product,viewModelCart,viewModel,mContext);
        });

        String temp = String.valueOf(product.getProductPrice());
        temp = temp.replace('.', ',');
        t.setProductPrice(temp);


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


}

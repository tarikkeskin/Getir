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
            openDialog(product);
        });

        String temp = String.valueOf(product.getProductPrice());
        temp = temp.replace('.', ',');
        t.setProductPrice(temp);


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    /**
     * This will construct An {@link AlertDialog} with some custom views.
     */
    private void openDialog(Products product) {
        //Inflating a LinearLayout dynamically to add TextInputLayout
        //This will be added in AlertDialog
        final LinearLayout linearLayout = (LinearLayout) ((Activity)mContext).getLayoutInflater().inflate(R.layout.view_number_dialog, null);
        NumberPicker numberpicker = (NumberPicker) linearLayout.findViewById(R.id.numberPicker1);


        numberpicker.setMinValue(1);
        numberpicker.setMaxValue(20);
        numberpicker.setValue(1);

        //Finally building an AlertDialog
        final AlertDialog builder = new AlertDialog.Builder(mContext)
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
                BottomSheetMaterialDialog mBottomSheetDialog = new BottomSheetMaterialDialog.Builder((Activity) mContext)
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
                    viewModel.add(product.getProductName(),
                            product.getProductImage(),
                            (int) product.getProductPrice(),
                            numberpicker.getValue(),
                            "tarik");

                }else{
                    viewModelCart.removeProductFromCart(Integer.parseInt(temp_id),"tarik");
                    viewModelCart.getAllCartProducts();
                    viewModel.add(product.getProductName(),
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

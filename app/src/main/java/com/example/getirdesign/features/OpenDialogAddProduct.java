package com.example.getirdesign.features;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import androidx.appcompat.app.AlertDialog;

import com.example.getirdesign.R;
import com.example.getirdesign.entities.Products;
import com.example.getirdesign.entities.SepetYemekler;
import com.example.getirdesign.viewmodel.HomePageFragmentViewModel;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;

import java.util.List;
import java.util.Objects;

import dev.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog;

public class OpenDialogAddProduct {

    /**
     * This will construct An {@link AlertDialog} with some custom views.
     */
    public void openDialog(Products product,MainPageFragmentViewModel viewModelCart,HomePageFragmentViewModel viewModelHomepage,Context mContext) {
        //Inflating a LinearLayout dynamically to add TextInputLayout
        //This will be added in AlertDialog
        final LinearLayout linearLayout = (LinearLayout) ((Activity)mContext).getLayoutInflater().inflate(R.layout.view_number_dialog, null);
        NumberPicker numberpicker = (NumberPicker) linearLayout.findViewById(R.id.numberPicker1);


        numberpicker.setMinValue(1);
        numberpicker.setMaxValue(20);
        numberpicker.setValue(1);

        //Finally building an AlertDialog
        final AlertDialog builder = new AlertDialog.Builder((Activity)mContext)
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
                BottomSheetMaterialDialog mBottomSheetDialog = new BottomSheetMaterialDialog.Builder((Activity)mContext)
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

package com.example.getirdesign.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getirdesign.MainActivity;
import com.example.getirdesign.R;
import com.example.getirdesign.databinding.CardSepetYemekBinding;
import com.example.getirdesign.entities.SepetYemekler;
import com.example.getirdesign.fragments.MainPageFragment;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SepetYemekAdapter extends RecyclerView.Adapter<SepetYemekAdapter.SepetYemeklerDesignAttachment> {

    private Context mContext;
    private List<SepetYemekler> sepetYemeklerList;
    private MainPageFragmentViewModel viewModel;

    public SepetYemekAdapter(Context mContext, List<SepetYemekler> sepetYemeklerList, MainPageFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.sepetYemeklerList = sepetYemeklerList;
        this.viewModel = viewModel;
    }

    public class SepetYemeklerDesignAttachment extends RecyclerView.ViewHolder{
        private CardSepetYemekBinding tasarim;
        public SepetYemeklerDesignAttachment(CardSepetYemekBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public SepetYemeklerDesignAttachment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardSepetYemekBinding tasarim = CardSepetYemekBinding.inflate(layoutInflater,parent,false);
        return new SepetYemeklerDesignAttachment(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull SepetYemeklerDesignAttachment holder, int position) {

        SepetYemekler sepetYemek = sepetYemeklerList.get(position);
        CardSepetYemekBinding t = holder.tasarim;

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+sepetYemek.getYemekResimAdi();
        Picasso.get().load(url).into(t.iVCardSepetYemekImage);

        t.tVSepetYemekName.setText(sepetYemek.getYemekAdi());
        t.tVSepetYemekAdet.setText(sepetYemek.getYemekSiparisAdet()+" adet");
        int tutar = Integer.parseInt(sepetYemek.getYemekFiyat())*Integer.parseInt(sepetYemek.getYemekSiparisAdet());
        t.tVSepetYemekFiyat.setText(String.valueOf(tutar)+" ₺");


        t.iVSepetYemekSil.setOnClickListener(view -> {
            Snackbar.make(view,"Ürünü sepetten kaldırmak istediğine emin misin?",Snackbar.LENGTH_LONG)
                    .setAction("Evet",view1 -> {
                        viewModel.removeProductFromCart(Integer.parseInt(sepetYemek.getSepetYemekId()),"tarik");
                        viewModel.getAllCartProducts();
                        if(sepetYemeklerList.size()==1) {
                            Intent intent = new Intent(mContext, MainActivity.class);
                            mContext.startActivity(intent);
                        }
                    })
                    .setActionTextColor(Color.WHITE)
                    .setTextColor(Color.WHITE)
                    .setBackgroundTint(Color.rgb(55,0,179))
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return sepetYemeklerList.size();
    }


}

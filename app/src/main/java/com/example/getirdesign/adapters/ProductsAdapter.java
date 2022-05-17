package com.example.getirdesign.adapters;

import android.content.Context;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getirdesign.R;
import com.example.getirdesign.entities.Products;
import com.example.getirdesign.databinding.CardProductDesingBinding;
import com.example.getirdesign.viewmodel.HomePageFragmentViewModel;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.CardDesignAttachment> {
    private Context mContext;
    private List<Products> productsList;
    private HomePageFragmentViewModel viewModel;
    private int adet;

    public ProductsAdapter(Context mContext, List<Products> productsList, HomePageFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.productsList = productsList;
        this.viewModel = viewModel;
    }

    public class CardDesignAttachment extends RecyclerView.ViewHolder{
        private CardProductDesingBinding tasarim;

        public CardDesignAttachment(CardProductDesingBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardDesignAttachment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardProductDesingBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_product_desing,parent,false);
        return new CardDesignAttachment(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignAttachment holder, int position) {
        Products product = productsList.get(position);
        CardProductDesingBinding t = holder.tasarim;

        t.setProductObject(product);

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+product.getProductImage();
        Picasso.get().load(url).into(t.imageViewProduct);

        t.CardViewAddCart.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

            builder.setTitle("Adet  giriniz..");

            final EditText input = new EditText(mContext);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);

            builder.setView(input);

            builder.setPositiveButton("OK", (dialog, which) -> {
                adet = Integer.parseInt(input.getText().toString());
                viewModel.add(product.getProductName(),product.getProductImage(), (int) product.getProductPrice(),adet,"tarik");
            });

            builder.setNegativeButton("İptal", (dialog, which) -> dialog.cancel());

            builder.show();

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

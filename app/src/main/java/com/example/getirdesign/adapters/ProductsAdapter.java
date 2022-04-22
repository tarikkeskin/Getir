package com.example.getirdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getirdesign.Products.Products;
import com.example.getirdesign.databinding.CardProductDesingBinding;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.CardDesignAttachment> {
    private Context mContext;
    private List<Products> productsList;

    public ProductsAdapter(Context mContext, List<Products> productsList) {
        this.mContext = mContext;
        this.productsList = productsList;
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
        CardProductDesingBinding tasarim = CardProductDesingBinding.inflate(layoutInflater,parent,false);
        return new CardDesignAttachment(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignAttachment holder, int position) {
        Products product = productsList.get(position);
        CardProductDesingBinding t = holder.tasarim;

        t.imageViewProduct.setImageResource(
                mContext.getResources().getIdentifier(product.getProductImage(),"drawable",mContext.getPackageName()));
        t.textViewProductName.setText(product.getProductName());

        String temp = String.valueOf(product.getProductPrice());
        temp = temp.replace('.', ',');
        t.textViewProductPrice.setText("₺"+temp);
        t.textViewWeight.setText(product.getProductWeight()+" g");

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

}

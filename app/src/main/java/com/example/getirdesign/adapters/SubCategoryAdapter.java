package com.example.getirdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getirdesign.Products.SubCategory;
import com.example.getirdesign.databinding.CardSubcategoryDesignBinding;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryDesignAttachment>{
    private Context mContext;
    private List<SubCategory> subCategoryList;

    public SubCategoryAdapter(Context mContext, List<SubCategory> subCategoryList) {
        this.mContext = mContext;
        this.subCategoryList = subCategoryList;
    }


    public class SubCategoryDesignAttachment extends RecyclerView.ViewHolder {
        private CardSubcategoryDesignBinding tasarim;

        public SubCategoryDesignAttachment(CardSubcategoryDesignBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }


    @NonNull
    @Override
    public SubCategoryDesignAttachment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardSubcategoryDesignBinding tasarim = CardSubcategoryDesignBinding.inflate(layoutInflater,parent,false);
        return new SubCategoryDesignAttachment(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryDesignAttachment holder, int position) {
        SubCategory subCategory = subCategoryList.get(position);
        CardSubcategoryDesignBinding t = holder.tasarim;
        t.textViewSubCategoryName.setText(subCategory.getSubCategoryName());

    }

    @Override
    public int getItemCount() {
        return subCategoryList.size();
    }


}

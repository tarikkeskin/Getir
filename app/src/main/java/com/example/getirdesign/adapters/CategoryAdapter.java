package com.example.getirdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getirdesign.Products.Category;
import com.example.getirdesign.databinding.CardCategoryDesingBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryDesignAttachment> {

    private Context mContext;
    private List<Category> categories;

    public CategoryAdapter(Context mContext, List<Category> categories) {
        this.mContext = mContext;
        this.categories = categories;
    }

    public class CategoryDesignAttachment extends RecyclerView.ViewHolder {
        private CardCategoryDesingBinding tasarim;

        public CategoryDesignAttachment(CardCategoryDesingBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CategoryDesignAttachment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardCategoryDesingBinding tasarim = CardCategoryDesingBinding.inflate(layoutInflater,parent,false);
        return new CategoryDesignAttachment(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryDesignAttachment holder, int position) {
        Category category = categories.get(position);
        CardCategoryDesingBinding t = holder.tasarim;

        t.textViewCategoryName.setText(category.getCategoryName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }



}

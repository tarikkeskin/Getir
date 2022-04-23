package com.example.getirdesign.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getirdesign.Products.Category;
import com.example.getirdesign.R;
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CategoryDesignAttachment holder, int position) {
        Category category = categories.get(position);
        CardCategoryDesingBinding t = holder.tasarim;

        t.textViewCategoryName.setText(category.getCategoryName());

        /**
         * Category View adapt Textview color
         */

        t.cardViewCategory.setOnClickListener(view -> {

            /* change card background color and underline text
            t.textViewCategoryName.setTextColor(Color.rgb(82,54,204));
            SpannableString content = new SpannableString(t.textViewCategoryName.getText().toString());
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            t.textViewCategoryName.setText(content);
            t.cardViewCategory.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.selector_card_subcategory));
             */

            if(t.cardViewCategory.isChecked()){
                t.frameCategoryCard.setBackgroundColor(Color.rgb(248,188,91));
            }else{
                t.frameCategoryCard.setBackgroundColor(Color.rgb(102,75,218));
            }

        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }



}

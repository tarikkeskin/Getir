package com.example.getirdesign.features;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.example.getirdesign.R;

public class CheckableCardView extends CardView implements Checkable {

    private boolean isChecked = false;


    public CheckableCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setCardBackgroundColor(
                ContextCompat.getColorStateList(getContext(), R.color.selector_card_view_colors)
        );
    }


    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }
    @Override
    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }
    @Override
    public boolean isChecked() {
        return isChecked;
    }
    @Override
    public void toggle() {
        setChecked(!this.isChecked);
    }

    private static final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked,
    };

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState =
                super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }



}

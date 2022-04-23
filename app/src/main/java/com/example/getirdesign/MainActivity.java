package com.example.getirdesign;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.getirdesign.databinding.BottomNavigationBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBinding tasarim;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = BottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        BadgeDrawable d = tasarim.bottomNav.getOrCreateBadge(R.id.giftsFragment);
        d.setNumber(8);
        d.setBackgroundColor(Color.rgb(82,54,204));



        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavigationUI.setupWithNavController(tasarim.bottomNav,navHostFragment.getNavController());

    }

    private void removeItemsUnderline(BottomNavigationView bottomNavigationView) {
        for (int i = 0; i <  bottomNavigationView.getMenu().size(); i++) {
            MenuItem item = tasarim.bottomNav.getMenu().getItem(i);
            item.setTitle(item.getTitle().toString());
        }
    }
}
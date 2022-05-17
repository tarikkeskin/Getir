package com.example.getirdesign;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.getirdesign.adapters.SepetYemekAdapter;
import com.example.getirdesign.databinding.BottomNavigationBinding;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;
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


}
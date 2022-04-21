package com.example.getirdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.getirdesign.databinding.BottomNavigationBinding;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBinding tasarim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = BottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavigationUI.setupWithNavController(tasarim.bottomNav,navHostFragment.getNavController());

    }
}
package com.example.getirdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.getirdesign.databinding.ActivityRegisterActivyBinding;
import com.example.getirdesign.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterActivyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterActivyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textViewGirisYap.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

    }
}
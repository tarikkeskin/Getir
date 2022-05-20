package com.example.getirdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.getirdesign.databinding.ActivityAnimationBinding;
import com.example.getirdesign.ui.login.LoginActivity;

public class AnimationActivity extends AppCompatActivity {
    private ActivityAnimationBinding binding;
    private static int SPLASH_SCREEN = 3000;

    private Animation getir_logo_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        binding = ActivityAnimationBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());

        //Animation
        getir_logo_anim = AnimationUtils.loadAnimation(this, R.anim.getir_logo_animation);

        binding.imageViewGetirLogo.setAnimation(getir_logo_anim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AnimationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
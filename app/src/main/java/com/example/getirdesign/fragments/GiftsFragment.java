package com.example.getirdesign.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getirdesign.R;
import com.example.getirdesign.databinding.FragmentGiftsBinding;


public class GiftsFragment extends Fragment {
    private FragmentGiftsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGiftsBinding.inflate(inflater, container, false);

        binding.giftanimation.setAnimation(R.raw.gift_animation);

        return binding.getRoot();
    }
}
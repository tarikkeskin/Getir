package com.example.getirdesign.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getirdesign.R;
import com.example.getirdesign.databinding.FragmentSearchBinding;


public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false);

        binding.searchAnimation.setAnimation(R.raw.search_animation);

        return binding.getRoot();
    }
}
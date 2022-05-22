package com.example.getirdesign.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.getirdesign.R;
import com.example.getirdesign.databinding.FragmentProfilBinding;


public class ProfilFragment extends Fragment {
    private FragmentProfilBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfilBinding.inflate(inflater, container, false);
        binding.profileAnimation.setAnimation(R.raw.profile_animation);

        return binding.getRoot();
    }
}
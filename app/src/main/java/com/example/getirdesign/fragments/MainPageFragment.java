package com.example.getirdesign.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getirdesign.R;
import com.example.getirdesign.databinding.FragmentMainPageBinding;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;


public class MainPageFragment extends Fragment {
    private FragmentMainPageBinding tasarim;
    private MainPageFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page ,container, false);


        viewModel.cartProductsList.observe(getViewLifecycleOwner(),list -> {
            Log.e("Product",list.toString());
        });


        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainPageFragmentViewModel.class);
    }
}
package com.example.getirdesign.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getirdesign.R;
import com.example.getirdesign.adapters.SepetYemekAdapter;
import com.example.getirdesign.databinding.FragmentMainPageBinding;
import com.example.getirdesign.viewmodel.MainPageFragmentViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.atomic.AtomicInteger;


public class MainPageFragment extends Fragment {
    private FragmentMainPageBinding binding;
    private MainPageFragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page ,container, false);

        binding.setFlagVisibleAnimation(true);

        AtomicInteger result = new AtomicInteger();
        viewModel.cartProductsList.observe(getViewLifecycleOwner(),list -> {
            SepetYemekAdapter adapter = new SepetYemekAdapter(requireContext(),list,viewModel);
            binding.setSepetAdapter(adapter);

            result.set(0);
            for (int i = 0; i < list.size(); i++) {
                result.addAndGet((Integer.parseInt(list.get(i).getYemekFiyat())*Integer.parseInt(list.get(i).getYemekSiparisAdet())));
            }

            binding.setFlagVisibleAnimation(false);
            binding.setFlagVisible(true);
            binding.setTotalFiyat(String.valueOf(result)+" ₺");

            if(list.size()!=0) {
                BottomNavigationView navigation = (BottomNavigationView) getActivity().findViewById(R.id.bottomNav);
                BadgeDrawable d = navigation.getOrCreateBadge(R.id.mainPageFragment);
                d.setNumber(list.size());
                d.setBackgroundColor(Color.rgb(82, 54, 204));
            }

        });



        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MainPageFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getAllCartProducts();
    }
}
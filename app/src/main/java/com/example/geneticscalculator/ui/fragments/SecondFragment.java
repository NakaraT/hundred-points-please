package com.example.geneticscalculator.ui.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.databinding.FragmentSecondBinding;
import com.example.geneticscalculator.ui.stateholder.adapters.DatesRecyclerAdapter;
import com.example.geneticscalculator.ui.stateholder.viewModels.DatesListViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SecondFragment extends Fragment {

    private DatesListViewModel model;
    private FragmentSecondBinding binding;
    private DatesRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(this).get(DatesListViewModel.class);
        adapter = new DatesRecyclerAdapter(this::openProfile);

        binding.recycleItem.setAdapter(adapter);
        model.listLiveData.observe(getViewLifecycleOwner(), adapter::setItems);
        binding.add.setOnClickListener(v -> model.addDates());
        binding.bottomNavigation.setSelectedItemId(R.id.navigation_item3);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item1:
                        Navigation.findNavController(view).navigate(R.id.action_second_to_home);
                        return true;
                    case R.id.navigation_item2:
                        Navigation.findNavController(view).navigate(R.id.action_second_to_menu);
                        return true;
                    case R.id.navigation_item3:
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    private void openProfile(int id) {
        findNavController(requireView()).navigate(SecondFragmentDirections.actionSecondToDate(id));
    }
}
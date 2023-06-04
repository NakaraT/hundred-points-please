package com.example.geneticscalculator.ui.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.databinding.FragmentMenuBinding;
import com.example.geneticscalculator.ui.stateholder.RelativesRecyclerAdapter;
import com.example.geneticscalculator.ui.stateholder.viewModels.RelativesListViewModel;

public class MenuFragment extends Fragment {

    private RelativesListViewModel model;
    private FragmentMenuBinding binding;
    private RelativesRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(this).get(RelativesListViewModel.class);
        adapter = new RelativesRecyclerAdapter(this::openProfile);
        binding.recycleItem.setAdapter(adapter);
        model.listLiveData.observe(getViewLifecycleOwner(), adapter::setItems);
        binding.add.setOnClickListener(v -> model.addRelative());
        binding.buttonBack.setOnClickListener(view1 ->
                findNavController(requireView()).navigate(R.id.action_menu_to_home)
        );
    }

    private void openProfile(int id) {
        findNavController(requireView()).navigate(MenuFragmentDirections.actionMenuToProfile(id));
    }
}

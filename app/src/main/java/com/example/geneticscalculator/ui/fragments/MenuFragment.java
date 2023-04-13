package com.example.geneticscalculator.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.R;

import com.example.geneticscalculator.data.models.RelativesListItem;
import com.example.geneticscalculator.databinding.FragmentMenuBinding;
import com.example.geneticscalculator.ui.stateholder.RelativesRecyclerAdapter;
import com.example.geneticscalculator.ui.stateholder.viewModels.RelativesListItemViewModel;
import com.example.geneticscalculator.ui.stateholder.viewModels.RelativesListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    private RelativesListViewModel model;
    private FragmentMenuBinding binding;
    private RelativesListItemViewModel viewModel;
    public static String KEY_POS = "pos";

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(RelativesListViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        model.listLiveData.observe(getViewLifecycleOwner(), new Observer<List<RelativesListItem>>() {
            @Override
            public void onChanged(List<RelativesListItem> items) {
                RelativesRecyclerAdapter adapter = new RelativesRecyclerAdapter(items);
                binding.recycleItem.setAdapter(adapter);
                adapter.onRelativesListItemListener = new RelativesRecyclerAdapter.OnRelativesListClickListener() {
                    @Override
                    public void onRelativesItemListClickListener(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(KEY_POS, position);
                        Navigation.findNavController(requireView()).navigate(R.id.action_menu_to_profile, bundle);
                    }

                };

            }
        });
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_menu_to_home);
            }
        });

    }
}

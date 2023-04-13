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
import com.example.geneticscalculator.databinding.FragmentRelativesprofileBinding;
import com.example.geneticscalculator.ui.stateholder.viewModels.RelativesListItemViewModel;

public class RelativesProfile extends Fragment {

    private FragmentRelativesprofileBinding binding;
    private RelativesListItemViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRelativesprofileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RelativesListItemViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        parseArgs();
        viewModel.relativesListItemLiveData.observe(getViewLifecycleOwner(), new Observer<RelativesListItem>() {
            @Override
            public void onChanged(RelativesListItem profileSettingListItem) {
                binding.relativesType.setText(RelativesListItem.getRelativesType());
                binding.eyeColor.setText(RelativesListItem.getEyeColor());
                binding.hairColor.setText(RelativesListItem.getHairColor());
                binding.skinColor.setText(RelativesListItem.getSkinColor());
                binding.bloodType.setText(RelativesListItem.getBloodType());
                binding.relativeLogo.setImageResource(R.drawable.relative);
                binding.buttonBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Navigation.findNavController(view).navigate(R.id.action_profile_to_home);
                    }
                });
            }
        });
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = bundle.getInt(MenuFragment.KEY_POS);
            viewModel.getRelativesListItemLiveData(position);
        }
    }
}

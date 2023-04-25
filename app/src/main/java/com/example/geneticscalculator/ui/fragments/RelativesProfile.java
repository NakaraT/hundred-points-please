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
import com.example.geneticscalculator.data.database.entity.RelativesEntity;
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
        viewModel.relativesListItemLiveData.observe(getViewLifecycleOwner(), new Observer<RelativesEntity>() {
            @Override
            public void onChanged(RelativesEntity relativesEntity) {
                binding.relativesType.setText(relativesEntity.getRelativesType());
                binding.eyeColor.setText(relativesEntity.getEyeColor());
                binding.hairColor.setText(relativesEntity.getHairColor());
                binding.skinColor.setText(relativesEntity.getSkinColor());
                binding.bloodType.setText(relativesEntity.getBloodType());
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

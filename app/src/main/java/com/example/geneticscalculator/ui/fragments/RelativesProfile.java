package com.example.geneticscalculator.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.databinding.FragmentRelativesprofileBinding;
import com.example.geneticscalculator.ui.stateholder.viewModels.RelativesListItemViewModel;

public class RelativesProfile extends Fragment {

    private RelativesListItemViewModel viewModel;
    private RelativesProfileArgs args;
    private FragmentRelativesprofileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = RelativesProfileArgs.fromBundle(getArguments());
        binding = FragmentRelativesprofileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RelativesListItemViewModel.class);
        viewModel.getRelativesItem(args.getId());
        viewModel.relativesListItemLiveData.observe(getViewLifecycleOwner(), relativesEntity -> {
            binding.relativesType.setText(relativesEntity.getRelativesType());
            binding.eyeColor.setText(relativesEntity.getEyeColor());
            binding.hairColor.setText(relativesEntity.getHairColor());
            binding.dateofBirth.setText(relativesEntity.getDateofBirth());
            binding.bloodType.setText(relativesEntity.getBloodType());
            binding.relativeLogo.setImageResource(R.drawable.relative);
        });

        binding.delete.setOnClickListener(v -> {
            viewModel.deleteRelative(args.getId());
            Navigation.findNavController(requireView()).navigateUp();
        });

        binding.update.setOnClickListener(v -> viewModel.updateRelative(
                args.getId(),
                binding.relativesType.getText().toString(),
                binding.eyeColor.getText().toString(),
                binding.hairColor.getText().toString(),
                binding.dateofBirth.getText().toString(),
                binding.bloodType.getText().toString()
        ));
        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.getId();
                viewModel.updateRelative(
                        args.getId(),
                        binding.relativesType.getText().toString(),
                        binding.eyeColor.getText().toString(),
                        binding.hairColor.getText().toString(),
                        binding.dateofBirth.getText().toString(),
                        binding.bloodType.getText().toString()
                );
                Toast.makeText(getContext(), "Данные обновлены!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.buttonBack.setOnClickListener(view1 ->
                Navigation.findNavController(requireView()).navigate(R.id.action_profile_to_menu)
        );
    }
}

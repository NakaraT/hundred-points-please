package com.example.geneticscalculator.ui.fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.databinding.FragmentAuthBinding;
import com.example.geneticscalculator.ui.stateholder.viewModels.AuthViewModel;

public class AuthFragment extends Fragment {
    private FragmentAuthBinding binding;
    private AuthViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewModel.loginAccount(
                        binding.editTextPhone.getText().toString(),
                        binding.editTextTextPassword.getText().toString()
                ))
                    Navigation.findNavController(view).navigate(R.id.action_auth_to_home);

            }
        });
        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_auth_to_signup);
            }
        });
    }
}
package com.example.geneticscalculator.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
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
    private static final String SHARED_PREF_NAME = "name";
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
        SharedPreferences sharedPrefRead =
                requireActivity().getPreferences(Context.MODE_PRIVATE);
        String loginSP = sharedPrefRead.getString(SHARED_PREF_NAME, "");
        binding.editTextPhone.setText(loginSP);

        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefWrite =
                        requireActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefWrite.edit();
                editor.putString(SHARED_PREF_NAME,
                        binding.editTextPhone.getText().toString());
                editor.apply();

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
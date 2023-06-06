package com.example.geneticscalculator.ui.fragments;

import static androidx.core.content.PermissionChecker.checkSelfPermission;
import android.content.Context;

import android.content.SharedPreferences;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
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
    public static final String KEYN = "numder";
    public static final String KEYP = "password";
    private AuthViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    private boolean allowedPermission() {
        if (checkSelfPermission(requireContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PermissionChecker.PERMISSION_GRANTED) {
            return true;
        }
        else {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        allowedPermission();
        SharedPreferences sharedPrefRead =
                requireActivity().getSharedPreferences("AuthFragment", Context.MODE_PRIVATE);
        String loginSP = sharedPrefRead.getString(SHARED_PREF_NAME, "");
        binding.editTextPhone.setText(loginSP);

        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPrefWrite =
                        requireActivity().getSharedPreferences("AuthFragment", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefWrite.edit();
                editor.putString(SHARED_PREF_NAME,
                        binding.editTextPhone.getText().toString());
                editor.apply();

                if(!(viewModel.loginAccount(
                        binding.editTextPhone.getText().toString(),
                        binding.editTextTextPassword.getText().toString()
                )))
                    Toast.makeText(getContext(), "Введите свои данные!", Toast.LENGTH_LONG).show();
                else
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
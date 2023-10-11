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
import com.example.geneticscalculator.data.models.LoginUser;
import com.example.geneticscalculator.data.session.AppSession;
import com.example.geneticscalculator.databinding.FragmentSignupBinding;
import com.example.geneticscalculator.ui.stateholder.viewModels.HomeViewModel;

public class SignUpFragment extends Fragment {
    private FragmentSignupBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String phone = binding.editTextPhone.getText().toString();
                String password = binding.editTextTextPassword.getText().toString();
                LoginUser user = new LoginUser(phone, password);
                AppSession.setSessionUser(user);

                Toast.makeText(getContext(), "Вы успешно зарегистрировались!", Toast.LENGTH_LONG).show();
                Navigation.findNavController(view).navigate(R.id.action_signup_to_auth);
            }
        });
    }
}

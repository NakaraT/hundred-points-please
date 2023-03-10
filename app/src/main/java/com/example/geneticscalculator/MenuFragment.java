package com.example.geneticscalculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.geneticscalculator.databinding.FragmentMenuBinding;


public class MenuFragment extends Fragment {
    private static final String TAG = "geneticscalculator";
    public static final String KEY = "key";

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }
    private FragmentMenuBinding binding;

    public void getArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null){
            String result = bundle.getString(KEY);
        }
    }
    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
        String result = bundle.getString("bundleKey");
    }
}

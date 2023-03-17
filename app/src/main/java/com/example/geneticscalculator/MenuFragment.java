package com.example.geneticscalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.databinding.FragmentMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<RecycleItem> listItems = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            listItems.add(new RecycleItem(R.drawable.relative, String.valueOf(i+1)));
        }
        RecycleAdapter adapter = new RecycleAdapter(getContext(), listItems);
        binding.recycleItem.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_menu_to_home);
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .addToBackStack(null)
//                        .replace(R.id.fragment_container, new HomeFragment())
//                        .commit();
            }
        });
    }
}

package com.example.geneticscalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {

    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    private FragmentSecondBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<ListItem> listItems = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            listItems.add(new ListItem(R.drawable.relative, String.valueOf(i+1)));
        }
        ListAdapter adapter = new ListAdapter(getContext(), R.layout.item_list, listItems);
        binding.listItem.setAdapter(adapter);
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_second_to_home);
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .addToBackStack(null)
//                        .replace(R.id.fragment_container, new HomeFragment())
//                        .commit();
            }
        });
    }
}
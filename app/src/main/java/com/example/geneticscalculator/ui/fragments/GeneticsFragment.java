package com.example.geneticscalculator.ui.fragments;


import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ViewUtils;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.databinding.FragmentGeneticsBinding;
import com.example.geneticscalculator.ui.stateholder.viewModels.HomeViewModel;

public class GeneticsFragment extends Fragment {
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private TextView chance1;
    private TextView chance2;
    private TableLayout tableLayout;
    private ImageButton buttonBack;
    private FragmentGeneticsBinding binding;

    private String[] parameters = {"A", "a"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_genetics, container, false);
        binding = FragmentGeneticsBinding.inflate(inflater, container, false);
        spinner1 = view.findViewById(R.id.spinner_1_2);
        spinner2 = view.findViewById(R.id.spinner_1_3);
        spinner3 = view.findViewById(R.id.spinner_2_1);
        spinner4 = view.findViewById(R.id.spinner_3_1);
        tableLayout = view.findViewById(R.id.tableLayout2);
        chance1 = view.findViewById(R.id.chance1);
        chance2 = view.findViewById(R.id.chance2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, parameters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateTable();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateTable();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateTable();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateTable();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return view;
    }

    private void updateTable() {
        String selectedParam1 = spinner1.getSelectedItem().toString();
        String selectedParam2 = spinner2.getSelectedItem().toString();
        String selectedParam3 = spinner3.getSelectedItem().toString();
        String selectedParam4 = spinner4.getSelectedItem().toString();

// Объединение ячеек по столбцу
        TextView cell1 = tableLayout.findViewById(R.id.cell1);
        String cell12 = selectedParam1 + selectedParam3;int aaCount = 0;
        aaCount += countSubstring(cell12, "aa");
        if (cell12.contains("A")) {
            cell12 = cell12.replace("aA", "Aa");
        }
        cell1.setText(cell12);

        TextView cell2 = tableLayout.findViewById(R.id.cell2);
        String cell22 = selectedParam2 + selectedParam3;
        aaCount += countSubstring(cell22, "aa");
        if (cell22.contains("aA")) {
            cell22 = cell22.replace("aA", "Aa");
        }
        cell2.setText(cell22);

        TextView cell3 = tableLayout.findViewById(R.id.cell3);
        String cell32 = selectedParam1 + selectedParam4;
        aaCount += countSubstring(cell32, "aa");
        if (cell32.contains("aA")) {
            cell32 = cell32.replace("aA", "Aa");
        }
        cell3.setText(cell32);

        TextView cell4 = tableLayout.findViewById(R.id.cell4);
        String cell42 = selectedParam2 + selectedParam4;
        aaCount += countSubstring(cell42, "aa");
        if (cell42.contains("aA")) {
            cell42 = cell42.replace("aA", "Aa");
        }
        cell4.setText(cell42);
        double countSub = (4 - aaCount) / 4.0 * 100;
        double countNeSub = 100 - countSub;
        chance1.setText(String.valueOf(countSub));
        chance2.setText(String.valueOf(countNeSub));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonBack = view.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(requireView()).navigate(R.id.action_genetics_to_home);
            }
        });
    }


    private int countSubstring(String str, String substr) {
        int count = 0;
        int idx = 0;
        while ((idx = str.indexOf(substr, idx)) != -1) {
            idx += substr.length();
            count++;
        }
        return count;
    }
}

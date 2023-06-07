package com.example.geneticscalculator.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.databinding.FragmentDatesprofileBinding;
import com.example.geneticscalculator.ui.stateholder.viewModels.DatesListItemViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatesProfile extends Fragment {

    private DatesListItemViewModel viewModel;
    private DatesProfileArgs args;
    private FragmentDatesprofileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = DatesProfileArgs.fromBundle(getArguments());
        binding = FragmentDatesprofileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DatesListItemViewModel.class);
        viewModel.getDatesItem(args.getId());
        viewModel.datesListItemLiveData.observe(getViewLifecycleOwner(), datesEntity -> {
            binding.datesType.setText(datesEntity.getDatesType());
            binding.datesInfo.setText(datesEntity.getDatesInfo());
            binding.datesText.setText(datesEntity.getDatesText());
            binding.datesInfo.setText(datesEntity.getDatesInfo());
            binding.datesLogo.setImageResource(R.drawable.ic_baseline_access_time_24);
        });

        binding.delete.setOnClickListener(v -> {
            viewModel.deleteDates(args.getId());
            Navigation.findNavController(requireView()).navigateUp();
        });

        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.getId();
                DatePicker datePicker = binding.calendar;
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                StringBuilder sb = new StringBuilder();
                StringBuilder sg = new StringBuilder();
                sg.append(day).append(".").append(month+1).append(".").append(year);
                sb.append("Дата : ").append(day).append(".").append(month+1).append(".").append(year);
                String result2 = sg.toString();
                String result = sg.toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
                Date currentDate = new Date();
                String formattedDate = sdf.format(currentDate);
                try {
                    Date date1 = sdf.parse(formattedDate);
                    Date date2 = sdf.parse(result2);
                    long diffInMillis = date2.getTime() - date1.getTime();
                    int diffInDays = (int) (diffInMillis / (24 * 60 * 60 * 1000));
                    StringBuilder st = new StringBuilder();
                    st.append("Осталось дней : ").append(String.valueOf(diffInDays));
                    String dInDays = st.toString();
                    binding.datesInfo.setText(String.valueOf(dInDays));
                }
                catch (ParseException e) {

                }
                binding.datesText.setText(result);
                viewModel.updateDates(
                        args.getId(),
                        binding.datesType.getText().toString(),
                        binding.datesInfo.getText().toString(),
                        binding.datesText.getText().toString()
                );
                Toast.makeText(getContext(), "Данные обновлены!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.buttonBack.setOnClickListener(view1 ->
                Navigation.findNavController(requireView()).navigate(R.id.action_date_to_second)
        );
    }
}

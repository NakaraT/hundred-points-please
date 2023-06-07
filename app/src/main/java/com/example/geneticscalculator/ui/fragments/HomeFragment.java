package com.example.geneticscalculator.ui.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.data.models.PlaceholderPost;
import com.example.geneticscalculator.databinding.FragmentHomeBinding;
import com.example.geneticscalculator.ui.stateholder.viewModels.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class HomeFragment extends Fragment {
    private HomeViewModel model;
    private FragmentHomeBinding binding;

    private static final String TAG = "geneticscalculator";
    public static final String KEY = "key";
    private final String CHANNEL_ID = "Channel1";
    public final int NOTIFIC_ID = 1;
    private final int REQUEST_CODE = 2;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(HomeViewModel.class);
        createNotificationChannel();
        super.onViewCreated(view, savedInstanceState);
        model.postLD.observe(getViewLifecycleOwner(), new Observer<PlaceholderPost>() {
            @Override
            public void onChanged(PlaceholderPost placeholderPost) {
                Log.d("getBody", placeholderPost.getBody());
            }
        });
        model.pushLD.observe(getViewLifecycleOwner(), new Observer<PlaceholderPost>() {
            @Override
            public void onChanged(PlaceholderPost placeholderPost) {
                binding.APIView.setText(placeholderPost.getTitle());
                Log.d("getTitle", placeholderPost.getTitle());
            }
        });
        model.getLD.observe(getViewLifecycleOwner(), new Observer<List<PlaceholderPost>>() {
            @Override
            public void onChanged(List<PlaceholderPost> placeholderPosts) {
                Log.d("getTitle(Posts)", placeholderPosts.get(50).getTitle());
            }
        });

        binding.bottomNavigation.setSelectedItemId(R.id.navigation_item1);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item1:
                        return true;
                    case R.id.navigation_item2:
                        Navigation.findNavController(view).navigate(R.id.action_home_to_menu);
                        return true;
                    case R.id.navigation_item3:
                        Navigation.findNavController(view).navigate(R.id.action_home_to_second);
                        return true;
                    default:
                        return false;
                }
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_home_to_genetics);
            }
        });


        binding.button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                textIntent.putExtra(Intent.EXTRA_SUBJECT, "Relatives info:");
                textIntent.putExtra(Intent.EXTRA_TEXT, "Я нашёл классное приложение!\nGeneticsCalculator - его название");
                requireActivity().startActivity(textIntent);
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            NotificationManager manager = (NotificationManager) getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }

    public void onStop() {
        //getActivity().startForegroundService(new Intent(getContext(), MyService.class));
//        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getActivity().getPackageName()));
//        startActivityForResult(intent, 2);
        super.onStop();
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, REQUEST_CODE );
            return;
        }
        notificationManager.notify(
                NOTIFIC_ID, builder.build()
        );
    }
}

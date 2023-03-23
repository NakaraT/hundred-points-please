package com.example.geneticscalculator;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.geneticscalculator.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

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
        createNotificationChannel();
        super.onViewCreated(view, savedInstanceState);
        binding.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(TAG, KEY);
                Navigation.findNavController(view).navigate(R.id.action_home_to_menu, bundle);
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .addToBackStack(null)
//                        .replace(R.id.fragment_container, new MenuFragment())
//                        .commit();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_home_to_second);
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .addToBackStack(null)
//                        .replace(R.id.fragment_container, new SecondFragment())
//                        .commit();
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                showNotification();
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
package com.example.geneticscalculator.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;

import com.example.geneticscalculator.R;
import com.example.geneticscalculator.ui.fragments.AuthFragment;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHost =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_container);
        NavGraph graph = navHost.getNavController()
                .getNavInflater().inflate(R.navigation.nav_graph);

        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if (type.equalsIgnoreCase("text/plain")) {
                    String textData = intent.getStringExtra(Intent.EXTRA_TEXT);
                    Bundle bundle = new Bundle();
                    bundle.putString(AuthFragment.KEYN, textData);
                    graph.setStartDestination(R.id.home);
                    navHost.getNavController().setGraph(graph, bundle);
                }
            } else {
                graph.setStartDestination(R.id.auth);
                navHost.getNavController().setGraph(graph);
            }
        }
    }
}
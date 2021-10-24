package com.example.android.labwork_2_1_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerlayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navView);
        drawerlayout = findViewById(R.id.drawer_layout);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.fragmentHome, R.id.fragment1, R.id.fragment2)
                .setOpenableLayout(drawerlayout)
                .build();

        NavController navController =
                Navigation.findNavController(this, R.id.nav_host_fragment);

        // Связать Controller Navigation с ActionBar
        NavigationUI.setupActionBarWithNavController(this,
                navController, mAppBarConfiguration);

        // Боковое меню
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    // Значек ящика
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
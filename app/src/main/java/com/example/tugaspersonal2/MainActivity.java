package com.example.tugaspersonal2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.*;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    MaterialToolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().hide();
        //setSupportActionBar(toolbar);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


    }

    public void updateToolbarTitle(String title) {
        // set namanya ganti ituteh wid
        // ini yang line getSupportActionBar, dia buat toolbar yang otomatis dari activity nya pas bikin
        // teteh kan ingin bikin toolbar punya sendiri, jadinya tabrakan sama yang otomatis ini makanya error
        // suruh pilih salah satu
        // haa i see, yg buat sendiri aja berarti bisa itu? boleh maksudnya?
        // bolelahh, cuman itu harus pilih salah satu wkwkkw, yang setSupportAction bar juga pengaruh tadi
        // ibaratnya toolbar yang custom di set ke toolbar otomatis, jadinya tabrakan lagi wkwkwk
        toolbar.setTitle(title);
        //getSupportActionBar().setTitle(title);
    }

    Fragment firstFragment = new FirstFragment();
    Fragment secondFragment = new SecondFragment();
    Fragment thirdFragment = new ThirdFragment();


    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, firstFragment)
                        .commit();
                return true;

            case R.id.form:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, secondFragment)
                        .commit();
                return true;

            case R.id.maps:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, thirdFragment)
                        .commit();
                return true;
        }
        return false;
    }
}

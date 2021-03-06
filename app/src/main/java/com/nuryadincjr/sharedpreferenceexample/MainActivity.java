package com.nuryadincjr.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.sharedpreferenceexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String comment;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = this.getPreferences(Context.MODE_PRIVATE);
        editor = preferences.edit();

        checkShare();
    }

    private void checkShare() {
        comment = preferences.getString(getString(R.string.commentars), "");
        binding.inputKomentar.setText(comment);
    }

    // siklus yang terjadi saat inputan telah dimasukan dan dikembalikan ke halaman beranda ponsel
    // yaitu : onPause - onStop - onDistroy, sehingga perlu penanganan saat aplikasi di distroy

    @Override
    protected void onPause() {
        super.onPause();
        comment = binding.inputKomentar.getText().toString();

        editor.putString(getString(R.string.commentars), comment);
        editor.commit();
    }
}
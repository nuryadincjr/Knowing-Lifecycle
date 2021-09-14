package com.nuryadincjr.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText comments;
    private String comment;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comments = findViewById(R.id.inputKomentar);

        preferences = this.getPreferences(Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    private void checkShare() {
        comment = preferences.getString(getString(R.string.commentars), "");
        comments.setText(comment);
    }

    // siklus yang terjadi saat inputan telah dimasukan dan dikembalikan ke halaman beranda ponsel
    // yaitu : onPause - onStop - onDistroy, sehingga perlu penanganan saat aplikasi di distroy

    @Override
    protected void onStart() {
        super.onStart();
        checkShare();
    }

    @Override
    protected void onPause() {
        super.onPause();
        comment = comments.getText().toString();

        editor.putString(getString(R.string.commentars), comment);
        editor.commit();
    }
}
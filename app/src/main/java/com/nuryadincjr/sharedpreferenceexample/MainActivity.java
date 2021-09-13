package com.nuryadincjr.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText comments;
    private String comment;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        comments = findViewById(R.id.inputKomentar);
//        Toast.makeText(this, "Siklus hidup onCreate " +comments.getText().toString(), Toast.LENGTH_SHORT).show();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
    }

    private void checkShare() {
//        String defValue = getResources().getString(R.string.app_name);
        comment = preferences.getString(getString(R.string.commentars), "");
        comments.setText(comment);
    }

    // siklus yang terjadi saat inputan telah dimasukan dan dikembalikan ke halaman beranda ponsel
    // yaitu : onPause - onStop - onDistroy, sehingga perlu penanganan saat aplikasi di distroy

    @Override
    protected void onStart() {
        super.onStart();
//        comment = comments.getText().toString();
//        Toast.makeText(this, "Siklus hidup onStart " + comment, Toast.LENGTH_SHORT).show();

        checkShare();
    }

    @Override
    protected void onPause() {
        super.onPause();
        comment = comments.getText().toString();
//        Toast.makeText(this, "Siklus hidup onPause " + comment, Toast.LENGTH_SHORT).show();

        editor.putString(getString(R.string.commentars), comment);
        editor.commit();
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        comment = comments.getText().toString();
//        Toast.makeText(this, "Siklus hidup onStop " + comment, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        comment = comments.getText().toString();
//        Toast.makeText(this, "Siklus hidup onDestroy " + comment, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        comment = comments.getText().toString();
//        Toast.makeText(this, "Siklus hidup onResume " + comment, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        comment = comments.getText().toString();
//        Toast.makeText(this, "Siklus hidup onRestart " + comment, Toast.LENGTH_SHORT).show();
//    }
}
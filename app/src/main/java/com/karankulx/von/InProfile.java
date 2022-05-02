package com.karankulx.von;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.karankulx.von.databinding.ActivityInProfileBinding;

public class InProfile extends AppCompatActivity {

    ActivityInProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
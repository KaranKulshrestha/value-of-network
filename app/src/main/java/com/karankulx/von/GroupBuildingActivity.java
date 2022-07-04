package com.karankulx.von;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.karankulx.von.Models.Users;
import com.karankulx.von.databinding.ActivityGroupBuildingBinding;

import java.util.ArrayList;

public class GroupBuildingActivity extends AppCompatActivity {

    ActivityGroupBuildingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGroupBuildingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
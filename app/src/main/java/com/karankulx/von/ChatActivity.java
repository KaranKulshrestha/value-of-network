package com.karankulx.von;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karankulx.von.databinding.ActivityChatBinding;


import net.alhazmy13.mediapicker.Image.ImagePicker;
import net.alhazmy13.mediapicker.Video.VideoPicker;

import java.util.List;
import java.util.Objects;

public class ChatActivity extends AppCompatActivity{
    Toolbar toolbar;
    TextView title;
    ImageView profile;
    ImageView aVideos;
    ImageView aImages;
    ImageView attach;
    View mLayout;

    ActivityChatBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        attach = findViewById(R.id.attachment);
        aImages = findViewById(R.id.photos);
        aVideos = findViewById(R.id.videos);

        View v = findViewById(R.id.popupIcons);
        v.animate().translationY(v.getHeight());

        mLayout = findViewById(R.id.mainLayout);


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.purple_500));


        String name = getIntent().getStringExtra("username");
        String profileUri = getIntent().getStringExtra("profileUri");
        toolbar = findViewById(R.id.toolbar);
        title = findViewById(R.id.username);
        profile = findViewById(R.id.profile_image);
        title.setText(name);
        Glide.with(this).load(profileUri).diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(profile);
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        attach.setOnClickListener(new View.OnClickListener() {
            int cond = 0;
            @Override
            public void onClick(View view) {
                if (cond == 0) {
                    v.setVisibility(View.VISIBLE);
                    cond = 1;
                } else {
                    v.setVisibility(View.GONE);
                    cond = 0;
                }

            }
        });

        aVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new VideoPicker.Builder(ChatActivity.this)
                        .mode(VideoPicker.Mode.CAMERA_AND_GALLERY)
                        .directory(VideoPicker.Directory.DEFAULT)
                        .extension(VideoPicker.Extension.MP4)
                        .enableDebuggingMode(true)
                        .build();

                hideSoftKeyboard(ChatActivity.this);
            }
        });


        aImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ImagePicker.Builder(ChatActivity.this)
                        .mode(ImagePicker.Mode.CAMERA_AND_GALLERY)
                        .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                        .directory(ImagePicker.Directory.DEFAULT)
                        .extension(ImagePicker.Extension.PNG)
                        .scale(600, 600)
                        .allowMultipleImages(true)
                        .enableDebuggingMode(true)
                        .build();
                hideSoftKeyboard(ChatActivity.this);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths = data.getStringArrayListExtra(ImagePicker.EXTRA_IMAGE_PATH);
            Log.d("hello mini", String.valueOf(mPaths.size()));
        } else if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths =  data.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH);
            //Your Code
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chat_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

}

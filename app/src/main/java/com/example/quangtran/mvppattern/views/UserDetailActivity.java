package com.example.quangtran.mvppattern.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quangtran.mvppattern.R;
import com.example.quangtran.mvppattern.models.Item;

public class UserDetailActivity extends Activity {

    private TextView mUserNameTextView, mGitHubUrlTextView;
    private ImageView mAvatarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        mUserNameTextView = findViewById(R.id.text_user_name);
        mGitHubUrlTextView = findViewById(R.id.text_github_url);
        mAvatarImageView = findViewById(R.id.image_avatar);
        Item user = getIntent().getParcelableExtra(MainActivity.EXTRA_USER);
        mUserNameTextView.setText(user.getLogin());
        mGitHubUrlTextView.setText(user.getHtmlUrl());
        Glide.with(this).load(user.getAvatarUrl()).into(mAvatarImageView);
    }
}

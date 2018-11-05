package com.example.quangtran.mvppattern.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quangtran.mvppattern.views.interface_views.OnRecyclerViewItemClickListener;
import com.example.quangtran.mvppattern.R;
import com.example.quangtran.mvppattern.presenters.GitHubUserAdapter;
import com.example.quangtran.mvppattern.models.Item;

import java.util.ArrayList;

public class ListGitHubUserActivity extends Activity
        implements OnRecyclerViewItemClickListener {
    private RecyclerView mRecyclerViewNewsFeed;
    private GitHubUserAdapter mGitHubUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_users);
        mRecyclerViewNewsFeed = findViewById(R.id.recycler_items);
        mGitHubUserAdapter = new GitHubUserAdapter(this);
        mGitHubUserAdapter.setOnRecyclerViewItemClickListener(this);
        mRecyclerViewNewsFeed.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false));
        mRecyclerViewNewsFeed.setAdapter(mGitHubUserAdapter);
        ArrayList<Item> items = getIntent()
                .getParcelableArrayListExtra(MainActivity.EXTRA_USER_LIST);
        mGitHubUserAdapter.updateData(items);
    }

    @Override
    public void onItemClick(Item item) {
        // create an intent
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(MainActivity.EXTRA_USER, item);
        this.startActivity(intent);
    }
}

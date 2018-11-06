package com.example.quangtran.mvppattern.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quangtran.mvppattern.views.interface_views.OnFetchDataListener;
import com.example.quangtran.mvppattern.R;
import com.example.quangtran.mvppattern.presenters.FetchDataFromUrl;
import com.example.quangtran.mvppattern.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFetchDataListener
        , View.OnClickListener {
    private EditText mKeywordEditText, mLimitNumberEditText;
    private Button mSearchButton;
    public static final String EXTRA_USER_LIST = "EXTRA_USER_LIST";
    public static final String EXTRA_USER = "EXTRA_USER";
    public static final String SEARCH = "Searching";
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mKeywordEditText = findViewById(R.id.edit_keywords);
        mLimitNumberEditText = findViewById(R.id.edit_limit_number);
        mSearchButton = findViewById(R.id.button_search);
        dialog = new ProgressDialog(this);
        dialog.setMessage(SEARCH);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onFetchDataSuccess(List<Item> users) {
        ArrayList<Item> items = (ArrayList<Item>) users;
        dialog.dismiss();
        Intent intent = new Intent(this, ListGitHubUserActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_USER_LIST, items);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        String keyword = mKeywordEditText.getText().toString();
        String limit = mLimitNumberEditText.getText().toString();
        String url = "https://api.github.com/search/users?per_page=" + limit + "&q=" + keyword;
        if (keyword.isEmpty() || limit.isEmpty()) {
            return;
        }
        dialog.show();
        new FetchDataFromUrl(MainActivity.this).execute(
                url);

    }
}

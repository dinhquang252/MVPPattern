package com.example.quangtran.mvppattern.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quangtran.mvppattern.Constant;
import com.example.quangtran.mvppattern.views.interface_views.OnFetchDataListener;
import com.example.quangtran.mvppattern.R;
import com.example.quangtran.mvppattern.presenters.FetchDataFromUrl;
import com.example.quangtran.mvppattern.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFetchDataListener {
    private EditText mKeywordEditText, mLimitNumberEditText;
    private Button mSearchButton;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mKeywordEditText = findViewById(R.id.keywordEdittext);
        mLimitNumberEditText = findViewById(R.id.limitNumberEdittext);
        mSearchButton = findViewById(R.id.searchButton);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = mKeywordEditText.getText().toString();
                String limit = mLimitNumberEditText.getText().toString();
                if (keyword.isEmpty() || limit.isEmpty()) {
                    return;
                }
                dialog.show();
                new FetchDataFromUrl(MainActivity.this).execute(
                        "https://api.github.com/search/users?per_page=" + limit + "&q=" + keyword);
            }
        });
    }

    @Override
    public void onFetchDataSuccess(List<Item> users) {
        ArrayList<Item> items = (ArrayList<Item>) users;
        dialog.dismiss();
        Intent intent = new Intent(this, ListGitHubUserActivity.class);
        intent.putParcelableArrayListExtra(Constant.EXTRA_USER_LIST, items);
        startActivity(intent);
    }
}

package com.example.rodneytressler.week3assessmentkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
//Elijah Smith
public class MainActivity extends AppCompatActivity implements AccountFragment.ActivityCallback {

    @BindView(R.id.welcome_text)
    protected TextView welcomeText;

    private AccountFragment accountFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AccountFragment accountFragment = AccountFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, accountFragment).commit();
        accountFragment.setCallback(this);


    }


    @Override
    public void createAccount(String name, String accountClass) {
        welcomeText.setText(getString(R.string.welcome,name,accountClass));
        getSupportFragmentManager().beginTransaction().remove(accountFragment);



    }
}

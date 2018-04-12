package com.nd.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nd.databindingdemo.databinding.ActivityMainBinding;
import com.nd.databindingdemo.model.User;

public class ActivityMain extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User();
        user.setName("Nayan Dabhi");
        user.setEmail("nayandabhi96@gmail.com");

        binding.setUser(user);
    }
}

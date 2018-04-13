package com.nd.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.nd.databindingdemo.databinding.ActivityMainBinding;
import com.nd.databindingdemo.model.User;

public class ActivityMain extends AppCompatActivity {
    private User user;

    private ActivityMainBinding binding;
    private MyClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        user = new User();
        user.setName("Nayan Dabhi");
        user.setEmail("nayandabhi96@gmail.com");
        binding.setUser(user);

        handlers = new MyClickHandlers(this);
        binding.setHandlers(handlers);
        binding.content.setHandlers(handlers);
    }

    public class MyClickHandlers {
        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onFabClicked(View view) {
            Toast.makeText(context, "FAB clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClick(View view) {
            Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClickWithParam(View view, User user) {
            Toast.makeText(context, "Button clicked! Name: " + user.getName(), Toast.LENGTH_SHORT).show();
        }

        public boolean onButtonLongPressed(View view) {
            Toast.makeText(context, "Button long pressed!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}

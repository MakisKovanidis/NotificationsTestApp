package com.example.makis.notificationstestproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=(TextView)findViewById(R.id.textView2);

        /*Gson gson = new Gson();
        JSONObject object = gson.fromJson(getIntent().getStringExtra("myjson"), User.class);
        Toast.makeText(getApplicationContext(), "token"+user.getAccessToken(), Toast.LENGTH_LONG).show();*/



    }
}

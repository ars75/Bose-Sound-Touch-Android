package com.example.adityasatalkar.bosesoundtouchapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit = (EditText) findViewById(R.id.IPAddress);
        final RestCalls restCalls = new RestCalls();
        final String IPADDRESS = "192.168.1.15";
        final BoseSoundTouch boseSoundTouch = new BoseSoundTouch();
        try {
            boseSoundTouch.setIP("192.168.1.15:8090");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;

        TextView ipAddressTextView = (TextView) findViewById(R.id.IPAddress);
        Button volumeup = (Button) findViewById(R.id.volumeup);
        volumeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                try {
                    JSONObject jsonObject = boseSoundTouch.setVolumeUp();
                    String volumeLevel = ParseJson.parseJson(jsonObject,"volume","actualvolume");
                    ipAddressTextView.setText(volumeLevel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button volumedown = findViewById(R.id.volumedown);
        volumedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                try {
                    JSONObject jsonObject = boseSoundTouch.setVolumeDown();
                    String volumeLevel = ParseJson.parseJson(jsonObject,"volume","actualvolume");
                    ipAddressTextView.setText(volumeLevel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button bassup = findViewById(R.id.bassup);
        bassup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                try {
                    JSONObject jsonObject = boseSoundTouch.setBassUp();
                    String bassLevel = ParseJson.parseJson(jsonObject,"bass","actualbass");
                    ipAddressTextView.setText(bassLevel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button bassdown = findViewById(R.id.bassdown);
        bassdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                try {
                    JSONObject jsonObject = boseSoundTouch.setBassDown();
                    String bassLevel = ParseJson.parseJson(jsonObject,"bass","actualbass");
                    ipAddressTextView.setText(bassLevel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
/*
    @Override
    public void onClick(View view) {
        BoseSoundTouch boseSoundTouch = new BoseSoundTouch();
        try {
            boseSoundTouch.setIP("192.168.1.15:8090");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextView ipAddressTextView = (TextView) findViewById(R.id.IPAddress);
        JSONObject jsonObject = null;
        switch (view.getId()) {
            case R.id.volumeup:
            case R.id.volumedown:
            case R.id.bassup:
            case R.id.bassdown:
        }
    }*/
}
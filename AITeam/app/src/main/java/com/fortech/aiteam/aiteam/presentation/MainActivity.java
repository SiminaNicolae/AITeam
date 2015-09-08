package com.fortech.aiteam.aiteam.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fortech.aiteam.aiteam.R;

public class MainActivity extends Activity {
    //03.06.15
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setTitle("Personal Assistent");
        getActionBar().setIcon(null);

        Button v = (Button) findViewById(R.id.button_next);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavDrawerActivity.class);
                startActivity(intent);
            }
        });
        
    }
}


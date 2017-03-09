package com.example.therishka.androidlabservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchService(false);
            }
        });
        findViewById(R.id.start_button_with_destroy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchService(true);
            }
        });
    }

    private void launchService(boolean withDestroy){
        Intent intent = new Intent(this, ExampleService.class);
        intent.putExtra("with_destroy", withDestroy);
        this.startService(intent);
        this.stopService(intent);
    }
}

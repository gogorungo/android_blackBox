package com.gunu.blackbox_v50;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    String test;
    String DirectoryName;
    Button btnNewActivity;
    Button btnNewActivity1;
    Button btnNewActivity2;
    Button btnNewActivity3;
    Button btnNewActivity4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Black Box 동영상 플레이어 v5.0");
        Log.d("test", "Black Box 동영상 플레이어 시작");

        ActivityCompat.requestPermissions(this, new String[] {
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);


        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity1 = (Button) findViewById(R.id.btnNewActivity1);
        btnNewActivity2 = (Button) findViewById(R.id.btnNewActivity2);
        btnNewActivity3 = (Button) findViewById(R.id.btnNewActivity3);
        btnNewActivity4 = (Button) findViewById(R.id.btnNewActivity4);

        test = "android.resource://" + getPackageName() + "/raw/small";
        btnNewActivity.setText(test);
        test = "android.resource://" + getPackageName() + "/raw/sample1";
        btnNewActivity1.setText(test);
        test = "android.resource://" + getPackageName() + "/raw/sample2";
        btnNewActivity2.setText(test);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                test = "android.resource://" + getPackageName() + "/raw/small";
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Name", test);
                startActivity(intent);
            }
        });
        btnNewActivity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                test = "android.resource://" + getPackageName() + "/raw/sample1";
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Name", test);
                startActivity(intent);
            }
        });
        btnNewActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                test = "android.resource://" + getPackageName() + "/raw/sample2";
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Name", test);
                startActivity(intent);
            }
        });
        btnNewActivity3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SetDerectoryName.class);
                startActivityForResult(intent, 0);
            }
        });
        btnNewActivity4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FileListView.class);
                intent.putExtra("Name", DirectoryName);
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            DirectoryName = data.getStringExtra("Directory");
            btnNewActivity4.setText("Directory Name : " + DirectoryName);
        }
    }
}

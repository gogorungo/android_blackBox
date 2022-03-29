package com.gunu.blackbox_v50;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class SetDerectoryName extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setdirectoryname);

        ListView directoryView;
        final ArrayList<String> midList = new ArrayList<String>();
        directoryView = (ListView) findViewById(R.id.directoryView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, midList);
        directoryView.setAdapter(adapter);

        String sysDir=SDCard.getExternalSDCardPath();
        if( sysDir.length()==0) {
            Log.d("test", "Empty");
            finish();
        } else Log.d("test", sysDir);

        File[] sysFiles = (new File(sysDir).listFiles());
        String strFname;

        for (int i = 0; i < sysFiles.length; i++) {
            if (sysFiles[i].isDirectory() == true) {
                strFname = sysFiles[i].toString();
                Log.d("test", strFname);
                midList.add(strFname.toString());
                adapter.notifyDataSetChanged();
            }
        }

        directoryView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("test", "결과" + midList.get(position));
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Directory", midList.get(position));
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
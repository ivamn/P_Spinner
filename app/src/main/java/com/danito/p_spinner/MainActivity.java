package com.danito.p_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner s = findViewById(R.id.spinner);
        final ImageView imageView = findViewById(R.id.image);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.imagenes, android.R.layout.simple_list_item_1);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String uri = "@drawable/" + parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, uri, Toast.LENGTH_LONG).show();
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                imageView.setImageResource(imageResource);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

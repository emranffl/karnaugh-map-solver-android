package com.emranffl.k_mapsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioButton ab;
    private RadioButton abc;
    private RadioButton abcd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ab = findViewById(R.id.ab);
        abc = findViewById(R.id.abc);
        abcd = findViewById(R.id.abcd);


        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (abc.isChecked()) {
                    abc.setChecked(false);
                } else if (abcd.isChecked()) {
                    abcd.setChecked(false);
                }

                ab.setChecked(false);
                startActivity(new Intent(getApplicationContext(), TwoVar_Layout.class));
            }
        });

        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (abcd.isChecked()) {
                    abcd.setChecked(false);
                } else if (ab.isChecked()) {
                    ab.setChecked(false);
                }

                abc.setChecked(false);
                startActivity(new Intent(getApplicationContext(), ThreeVar_Layout.class));
            }
        });

        abcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ab.isChecked()) {
                    ab.setChecked(false);
                } else if (abc.isChecked()) {
                    abc.setChecked(false);
                }

                abcd.setChecked(false);
                startActivity(new Intent(getApplicationContext(), FourVar_Layout.class));
            }
        });


    }
}

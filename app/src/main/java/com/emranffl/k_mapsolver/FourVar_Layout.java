package com.emranffl.k_mapsolver;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FourVar_Layout extends AppCompatActivity implements View.OnClickListener {

    private Button[] buttons;
    private EditText textpane;
    private Button reset;
    private Button solve;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourvar_layout);

        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3),
                findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6), findViewById(R.id.button7),
                findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.button10), findViewById(R.id.button11),
                findViewById(R.id.button12), findViewById(R.id.button13), findViewById(R.id.button14), findViewById(R.id.button15)};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }

        textpane = findViewById(R.id.textpane);
        reset = findViewById(R.id.reset);
        solve = findViewById(R.id.solve);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // resets two variable panel buttons
                for (Button fourvarlocal : buttons) {
                    fourvarlocal.setText("0");
                }
                textpane.setText(null);
            }
        });

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val[];
                String soln;

                // executes when two variable is selected
                val = new int[16];

                for (int i = 0; i < val.length; i++) {
                    // stores value from button text
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }

                // creates instance of two variable solver
                FourVarSolver solver = new FourVarSolver(val);
                // solves and stores result
                soln = solver.solve();

                // sets the result to text pane
                if (soln.isEmpty()) {
                    textpane.setText(null);
                } else {
                    new ResultTypeOptimizer(getContext(), soln, textpane);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        b = (Button) v;

        if (b.getText().toString().matches("0")) {
            b.setText("1");
        } else {
            b.setText("0");
        }
    }

    private Context getContext() {
        return this;
    }
}

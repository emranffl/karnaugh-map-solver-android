package com.emranffl.k_mapsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThreeVar_Layout extends AppCompatActivity implements View.OnClickListener {

    private Button[] buttons;
    private EditText textpane;
    private Button reset;
    private Button solve;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threevar_layout);

        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3),
                findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6), findViewById(R.id.button7)};
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
                for (Button threevarlocal : buttons) {
                    threevarlocal.setText("0");
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
                val = new int[8];

                for (int i = 0; i < val.length; i++) {
                    // stores value from button text
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }

                // creates instance of two variable solver
                ThreeVarSolver solver = new ThreeVarSolver(val);
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

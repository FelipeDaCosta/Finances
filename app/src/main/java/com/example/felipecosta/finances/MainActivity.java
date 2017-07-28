package com.example.felipecosta.finances;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView money;
    private TextView lastUpdate;

    private Toolbar myToolbar;

    private ImageButton graph;
    private ImageButton calculator;
    private ImageButton savings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        money = (TextView) this.findViewById(R.id.money);
        money.setText("R$ 20,27");

        lastUpdate = (TextView) this.findViewById(R.id.last_update);
        lastUpdate.setText("Last expense: R$ 30,40 in 20/20/2020");

        this.createImageButtons();

        myToolbar = (Toolbar) this.findViewById(R.id.my_toolbar);
        this.setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    private void createImageButtons() {
        graph = (ImageButton) this.findViewById(R.id.graph_button);
        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Graph Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        calculator = (ImageButton) this.findViewById(R.id.calculator_button);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Calculator Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        savings = (ImageButton) this.findViewById(R.id.savings_button);
        savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Savings Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.felipecosta.finances;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Constants{

    User user;

    private TextView money;
    private TextView lastUpdate;

    private Toolbar myToolbar;

    private ImageButton graph;
    private ImageButton calculator;
    private ImageButton savings;

    private MenuItem gain;
    private MenuItem loss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Change this later
        user = new User();
        user.deposit(1234.56);

        money = (TextView) this.findViewById(R.id.money);
        money.setText(String.valueOf(this.user.getMoney()));

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent updateActivity = new Intent(this, UpdateActivity.class);
        int gain_or_loss = 0;
        switch(item.getItemId()) {
            case R.id.action_gain:
                gain_or_loss = REQUEST_TOOLBAR_GAIN;
                break;
            case R.id.action_loss:
                gain_or_loss = REQUEST_TOOLBAR_LOSS;
                break;
        }
        updateActivity.putExtra(GAIN_OR_LOSS, gain_or_loss);
        this.startActivityForResult(updateActivity, gain_or_loss);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_TOOLBAR_LOSS) {
            double amount = data.getDoubleExtra(AMOUNT, 0.0);
            this.user.withdraw(amount);
            this.money.setText(String.valueOf(this.user.getMoney()));
        }
        else if(requestCode == REQUEST_TOOLBAR_GAIN) {
            double amount = data.getDoubleExtra(AMOUNT, 0.0);
            user.deposit(amount);
            this.money.setText(String.valueOf(this.user.getMoney()));
        }

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

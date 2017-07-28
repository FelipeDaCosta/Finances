package com.example.felipecosta.finances;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements Constants{
    private TextView desc;
    private EditText input;
    private Button okButton;

    private boolean isGain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        isGain = (this.getIntent().getIntExtra(GAIN_OR_LOSS, 0) == REQUEST_TOOLBAR_GAIN);

        desc = (TextView) this.findViewById(R.id.gain_or_loss);
        if(isGain) {
            desc.setText("Gain");
        } else {
            desc.setText("Loss");
        }

        input = (EditText) this.findViewById(R.id.money_amount);
        okButton = (Button) this.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double amount = Double.parseDouble(input.getText().toString());
                    int result = isGain ? REQUEST_TOOLBAR_GAIN : REQUEST_TOOLBAR_LOSS;
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(AMOUNT, amount);
                    setResult(result, returnIntent);
                    finish();

                } catch (NumberFormatException e) {
                    Toast.makeText(UpdateActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    input.setText("");
                }
            }
        });
    }


}

package in.ac.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button plus, minus, reset, check;
    TextView quant;
    CheckBox crm, chk;
    int coffee = 0;
    int total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.button2);
        minus = findViewById(R.id.button);
        check = findViewById(R.id.button3);
        reset = findViewById(R.id.button4);
        crm = findViewById(R.id.checkBox);
        chk = findViewById(R.id.checkBox2);
        quant = findViewById(R.id.textView4);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coffee > 0)
                    coffee--;
                quant.setText(String.valueOf(coffee));
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coffee > 0)
                    coffee++;
                quant.setText(String.valueOf(coffee));
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crm.isChecked() && coffee > 0) {
                    total += 5 * coffee;
                }
                if (chk.isChecked() && coffee > 0) {
                    total += 5 * coffee;
                }
                if (coffee > 0) {
                    if (crm.isChecked() && chk.isChecked()) {
                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee) + "Coffee with Cream and Chocolate. Your Bill is "
                                + String.valueOf(total), Toast.LENGTH_SHORT).show();

                    } else if (crm.isChecked()) {
                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee) + "Coffee with Cream . Your Bill is "
                                + String.valueOf(total), Toast.LENGTH_SHORT).show();
                    } else if (chk.isChecked()) {
                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee) + "Coffee with Chocolate. Your Bill is "
                                + String.valueOf(total), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "You have selected " + String.valueOf(coffee) + "Coffee with no Toppings. Your Bill is "
                                + String.valueOf(total), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No Coffee selected ..", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0;
                coffee = 0;
                quant.setText(String.valueOf(coffee));
                crm.setChecked(false);
                chk.setChecked(false);

            }
        });
    }
}
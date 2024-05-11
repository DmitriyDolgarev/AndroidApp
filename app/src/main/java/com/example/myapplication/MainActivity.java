package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

import Logic.Calculator;

public class MainActivity extends AppCompatActivity {
    private Button calculateBtn;
    private EditText horsePowerValue;
    private TextView rentValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Calculator calculator = new Calculator(this);

        calculateBtn = findViewById(R.id.calculateBtn);
        horsePowerValue = findViewById(R.id.editHorsePower);
        rentValue = findViewById(R.id.valueTV);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("HorsePower",  horsePowerValue.getText().toString());
                if (horsePowerValue.getText().toString().isEmpty())
                {
                    rentValue.setText("Введите необходимое количество лошадиных сил!");
                }
                else
                {
                    String result = calculator.getValue(Integer.parseInt(horsePowerValue.getText().toString())) + getResources().getString(R.string.rub_txt);

                    rentValue.setText(result);
                }
            }
        });
    }
}
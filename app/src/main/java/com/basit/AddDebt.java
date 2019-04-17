package com.basit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddDebt extends AppCompatActivity {

    Button backButton;
    Button save;

    EditText inputAmount, inputTitle, inputDescription;

    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debt);

        backButton = findViewById( R.id.backButton);
        inputAmount = findViewById( R.id.inputAmount);
        inputTitle = findViewById(R.id.inputTitle);
        inputDescription = findViewById( R.id.inputDescription);
        save = findViewById( R.id.saveButton);

        db = new DatabaseHelper( AddDebt.this);



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = inputAmount.getText().toString();
                String title = inputTitle.getText().toString();
                String description = inputDescription.getText().toString();

                try{
                    if( amount != null && amount != "" && amount != "0.0"){
                        db.addDebt(amount, title, description, Calendar.getInstance().get(Calendar.MONTH) + 1,
                                Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.DATE), new dbCallBack() {
                                    @Override
                                    public void onCallBack(ArrayList debt, double totalDebt, ArrayList expense, double totalExpense, boolean result) {
                                        if( result){
                                            Toast.makeText( AddDebt.this, "Debt added successfully", Toast.LENGTH_SHORT).show();
                                            onBackPressed();
                                        }
                                        else{
                                            Toast.makeText( AddDebt.this, "Error adding debt", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                } catch ( Exception e){
                    Toast.makeText( AddDebt.this, "Error adding debt", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

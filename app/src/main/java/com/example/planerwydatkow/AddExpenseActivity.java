package com.example.planerwydatkow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_expense);

        EditText expenseDescription = findViewById(R.id.expenseDescriptionEditText);
        EditText expenseAmount = findViewById(R.id.expenseAmountEditText);
        Spinner paidBySpinner = findViewById(R.id.paidBySpinner);
        Button saveExpenseButton = findViewById(R.id.saveExpenseButton);

        // Odbieranie listy użytkowników
        Intent intent = getIntent();
        ArrayList<String> userNames = intent.getStringArrayListExtra("users");

        if (userNames == null || userNames.isEmpty()) {
            finish(); // Zamknij aktywność, jeśli lista użytkowników jest pusta
        }

        // Ustawianie spinnera
        assert userNames != null;
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                userNames
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paidBySpinner.setAdapter(spinnerAdapter);

        // Obsługa przycisku zapisu
        saveExpenseButton.setOnClickListener(v -> {
            String description = expenseDescription.getText().toString();
            double amount = Double.parseDouble(expenseAmount.getText().toString());
            String paidBy = paidBySpinner.getSelectedItem().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("description", description);
            resultIntent.putExtra("amount", amount);
            resultIntent.putExtra("paidBy", paidBy);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}

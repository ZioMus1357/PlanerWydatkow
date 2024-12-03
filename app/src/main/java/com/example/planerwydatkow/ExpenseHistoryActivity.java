package com.example.planerwydatkow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planerwydatkow.models.Expense;

import java.util.ArrayList;

public class ExpenseHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_history);

        // Pobranie ListView z układu
        ListView expenseListView = findViewById(R.id.expenseListView);

        // Odbiór danych o wydatkach
        ArrayList<Expense> expenses = (ArrayList<Expense>) getIntent().getSerializableExtra("expenses");

        // Przygotowanie listy tekstowej z wydatkami
        ArrayList<String> expenseDetails = new ArrayList<>();
        assert expenses != null;
        for (Expense expense : expenses) {
            @SuppressLint("DefaultLocale") String detail = "Description: " + expense.getDescription() +
                    "\nAmount: " + String.format("%.2f zł", expense.getAmount()) +
                    "\nPaid by: " + expense.getPaidBy();
            expenseDetails.add(detail);
        }

        // Ustawienie adaptera do wyświetlenia wydatków
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, expenseDetails);
        expenseListView.setAdapter(adapter);
    }
}

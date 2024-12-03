package com.example.planerwydatkow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.planerwydatkow.models.Expense;
import com.example.planerwydatkow.models.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> users; // Lista użytkowników jako obiekty User
    private ArrayList<Expense> expenses; // Lista wydatków jako obiekty Expense
    private ArrayAdapter<String> userAdapter; // Adapter do ListView użytkowników
    private ListView userListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja elementów UI
        userListView = findViewById(R.id.userListView);

        // Inicjalizacja list
        users = new ArrayList<>();
        expenses = new ArrayList<>();

        // Adapter dla listy użytkowników
        userAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                getUserListWithBalances()
        );
        userListView.setAdapter(userAdapter);

        // Obsługa przycisku "Add User"
        findViewById(R.id.addUserButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivityForResult(intent, 1);
        });

        // Obsługa przycisku "Add Expense"
        findViewById(R.id.addExpenseButton).setOnClickListener(v -> {
            if (users.isEmpty()) {
                Toast.makeText(this, "No users available. Add users first.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
                intent.putStringArrayListExtra("users",
                        users.stream().map(User::getName).collect(Collectors.toCollection(ArrayList::new)));
                startActivityForResult(intent, 2);
            }
        });

        /* Obsługa przycisku "Calculate Balances"
        findViewById(R.id.calculateBalancesButton).setOnClickListener(v -> {
            calculateBalances();
            updateUserListView();
            Toast.makeText(this, "Balances updated!", Toast.LENGTH_SHORT).show();
        });
        */
        // Obsługa przycisku "View Expense History"
        findViewById(R.id.viewExpensesButton).setOnClickListener(v -> {
            if (expenses.isEmpty()) {
                Toast.makeText(this, "No expenses to display.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, ExpenseHistoryActivity.class);
                intent.putExtra("expenses", expenses);
                startActivity(intent);
            }
        });

        // Obsługa przycisku "Clear data"
        findViewById(R.id.clearDataButton).setOnClickListener(v -> showClearDataConfirmationDialog());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Dodawanie użytkownika
            String userName = data.getStringExtra("userName");
            if (userName != null && users.stream().noneMatch(user -> user.getName().equals(userName))) {
                users.add(new User(userName)); // Tworzenie obiektu User
                updateUserListView();
                calculateBalances();
                Toast.makeText(this, "User added: " + userName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "User already exists.", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            // Dodawanie wydatku
            String description = data.getStringExtra("description");
            double amount = data.getDoubleExtra("amount", 0.0);
            String paidBy = data.getStringExtra("paidBy");

            if (description != null && paidBy != null) {
                Expense expense = new Expense(description, amount, paidBy);
                expenses.add(expense);
                Toast.makeText(this, "Expense added: " + description, Toast.LENGTH_SHORT).show();

                // Automatyczne obliczanie sald po dodaniu wydatku
                calculateBalances();
            }
        }
    }

    // Funkcja obliczająca podział kosztów
    private void calculateBalances() {
        if (expenses.isEmpty()) {
            Toast.makeText(this, "No expenses to calculate.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Resetowanie sald użytkowników
        for (User user : users) {
            user.setBalance(0.0);
        }

        // Obliczanie sald na podstawie wydatków
        for (Expense expense : expenses) {
            String paidBy = expense.getPaidBy();
            double amount = expense.getAmount();
            double share = amount / users.size();

            for (User user : users) {
                if (user.getName().equals(paidBy)) {
                    user.updateBalance(amount - share); // Aktualizacja balansu płacącego
                } else {
                    user.updateBalance(-share); // Aktualizacja balansu innych
                }
            }
        }

        // Zaktualizowanie widoku listy użytkowników
        updateUserListView();
    }

    // Metoda do aktualizowania listy użytkowników w widoku
    private void updateUserListView() {
        userAdapter.clear();
        userAdapter.addAll(getUserListWithBalances());
        userAdapter.notifyDataSetChanged();
    }

    // Funkcja generująca listę nazw użytkowników z saldami
    private ArrayList<String> getUserListWithBalances() {
        return users.stream()
                .map(user -> user.getName() + " - Balance: " + String.format("%.2f zł", user.getBalance()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    // zapytanie przed usunieciem danych
    private void showClearDataConfirmationDialog() {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Clear All Data")
                .setMessage("Are you sure you want to clear all users and expenses? This action cannot be undone.")
                .setPositiveButton("Yes", (dialog, which) -> clearAllData())
                .setNegativeButton("No", null)
                .show();
    }

    //usuwanie danych
    private void clearAllData() {
        users.clear();
        expenses.clear();
        updateUserListView();
        Toast.makeText(this, "All data has been cleared.", Toast.LENGTH_SHORT).show();
    }

}

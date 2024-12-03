package com.example.planerwydatkow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        EditText userNameEditText = findViewById(R.id.userNameEditText);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String userName = userNameEditText.getText().toString().trim();

            if (!userName.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("userName", userName);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                userNameEditText.setError("Name cannot be empty");
            }
        });
    }
}

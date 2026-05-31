package com.example.finalprojectstipass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etStudentId, etEmail;

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });

        etStudentId = findViewById(R.id.etStudentId);
        etEmail = findViewById(R.id.etEmail);
        Button btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(v -> {
            String studentID = etStudentId.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            if (studentID.isEmpty()) {
                etStudentId.setError("Please enter Student ID");
                etStudentId.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                etEmail.setError("Please enter STI Email");
                etEmail.requestFocus();
                return;
            }

            // Validation Logic
            if (studentID.equals("0200012345") && email.equals("student@sti.edu.ph")) {
                // Success
                Toast.makeText(MainActivity.this, "Student verified successfully!", Toast.LENGTH_SHORT).show();
                
                Intent intent = new Intent(MainActivity.this, CreatePasswordActivity.class);
                startActivity(intent);
            } else {
                // Failure
                Toast.makeText(MainActivity.this, "Invalid Student ID or STI Email!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

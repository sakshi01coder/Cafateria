package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AuthActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText, sapIdEditText;
    Button loginButton, registerButton;
    FirebaseAuth mAuth;
    FirebaseFirestore db; // Added Firestore instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        sapIdEditText = findViewById(R.id.sapIdEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance(); // Initialize Firestore

        loginButton.setOnClickListener(v -> loginUser());
        registerButton.setOnClickListener(v -> registerUser());
    }

    private void loginUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                    // 🔽 Get current user and extract username or SAP ID
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    if (firebaseUser != null) {
                        String username;
                        if (firebaseUser.getDisplayName() != null && !firebaseUser.getDisplayName().isEmpty()) {
                            username = firebaseUser.getDisplayName(); // Use SAP ID as username
                        } else {
                            String emailUser = firebaseUser.getEmail();
                            username = (emailUser != null && emailUser.contains("@")) ?
                                    emailUser.substring(0, emailUser.indexOf("@")) : "User";
                        }

                        // 🔽 Start HomeActivity with USERNAME
                        Intent intent = new Intent(AuthActivity.this, HomeActivity.class);
                        intent.putExtra("USERNAME", username);
                        startActivity(intent);
                        finish(); // Optional: close AuthActivity
                    }
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this, "Login Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }


    private void registerUser() {
        String emailInput = emailEditText.getText().toString();
        String passwordInput = passwordEditText.getText().toString();
        String sapIdInput = sapIdEditText.getText().toString();

        if (emailInput.isEmpty() || passwordInput.isEmpty() || sapIdInput.isEmpty()) {
            Toast.makeText(this, "Please enter email, password, and SAP ID", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailInput, passwordInput)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    if (firebaseUser != null) {
                        String uid = firebaseUser.getUid();

                        // Set display name to SAP ID
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setDisplayName(sapIdInput)
                                .build();
                        firebaseUser.updateProfile(profileUpdates).addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(this, "Registration Successful with SAP ID", Toast.LENGTH_SHORT).show();
                            }
                        });

                        // Save user details to Firestore
                        Map<String, Object> userMap = new HashMap<>();
                        userMap.put("email", emailInput);
                        userMap.put("sapId", sapIdInput);
                        userMap.put("uid", uid);
                        userMap.put("registeredAt", FieldValue.serverTimestamp());

                        db.collection("users").document(uid)
                                .set(userMap)
                                .addOnSuccessListener(aVoid -> {
                                    Log.d("FIRESTORE", "User profile created!");
                                })
                                .addOnFailureListener(e -> {
                                    Log.e("FIRESTORE", "Error adding user", e);
                                });
                    }
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this, "Sign Up Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}

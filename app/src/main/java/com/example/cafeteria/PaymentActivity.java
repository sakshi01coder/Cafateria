package com.example.cafeteria;
// PaymentActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID; // For generating a more unique ID

public class PaymentActivity extends AppCompatActivity {

    private TextView totalAmountTextView;
    private ImageView qrImageView;
    private EditText nameInput;
    private EditText rollInput;
    private Spinner timeSpinner;
    private Button confirmButton;

    private double totalAmount = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);

        totalAmountTextView = findViewById(R.id.totalAmount);
        qrImageView = findViewById(R.id.qrImage);
        nameInput = findViewById(R.id.nameInput);
        rollInput = findViewById(R.id.rollInput);
        timeSpinner = findViewById(R.id.timeSpinner);
        confirmButton = findViewById(R.id.confirmButton);

        // Retrieve the total amount passed from CartActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("totalAmount")) {
            totalAmount = extras.getDouble("totalAmount", 0.0);
            totalAmountTextView.setText("Total: " + String.format(Locale.getDefault(), "₹%.2f", totalAmount));
        }

        // Populate the time spinner
        List<String> pickupTimes = new ArrayList<>();
        pickupTimes.add("10:00 AM - 10:30 AM");
        pickupTimes.add("10:30 AM - 11:00 AM");
        pickupTimes.add("11:00 AM - 11:30 AM");
        pickupTimes.add("11:30 AM - 12:00 PM");
        pickupTimes.add("12:00 PM - 12:30 PM");
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pickupTimes);
        timeSpinner.setAdapter(timeAdapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String rollNumber = rollInput.getText().toString().trim();
                String selectedTime = timeSpinner.getSelectedItem().toString();

                if (name.isEmpty()) {
                    nameInput.setError("Name is required");
                    return;
                }
                if (rollNumber.isEmpty()) {
                    rollInput.setError("Roll Number is required");
                    return;
                }

                // Simulate payment confirmation
                String paymentConfirmationMessage = "Payment of " + String.format(Locale.getDefault(), "₹%.2f", totalAmount) + " confirmed.";
                Toast.makeText(PaymentActivity.this, paymentConfirmationMessage, Toast.LENGTH_SHORT).show();

                // Generate a unique order ID
                String orderId = generateOrderId();

                // Navigate to the OrderConfirmationActivity
                Intent confirmationIntent = new Intent(PaymentActivity.this, OrderConfirmationActivity.class);
                confirmationIntent.putExtra("orderId", orderId);
                startActivity(confirmationIntent);

                // In a real application, you would also:
                // 1. Process the payment using a payment gateway.
                // 2. Store the order details in a database.
            }
        });
    }

    // Method to generate a more unique order ID
    private String generateOrderId() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomPart = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return "ORDER-" + timestamp.substring(timestamp.length() - 8) + "-" + randomPart;
    }
}
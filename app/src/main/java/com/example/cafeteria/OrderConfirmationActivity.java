package com.example.cafeteria;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderConfirmationActivity extends AppCompatActivity {

    private TextView orderIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        orderIdTextView = findViewById(R.id.orderIdTextView);

        // Retrieve the order ID passed from PaymentActivity
        String orderId = getIntent().getStringExtra("orderId");

        if (orderId != null) {
            orderIdTextView.setText("Your Order ID: " + orderId);
        } else {
            orderIdTextView.setText("Order ID not found.");
        }
    }
}
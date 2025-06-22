package com.example.cafeteria;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartersActivity extends AppCompatActivity {

    // Declare views for each starter item
    private ImageView itemImage8, itemImage9, itemImage10, itemImage11, itemImage12, itemImage13, itemImage14;
    private TextView itemName8, itemName9, itemName10, itemName11, itemName12, itemName13, itemName14;
    private TextView itemPrice8, itemPrice9, itemPrice10, itemPrice11, itemPrice12, itemPrice13, itemPrice14;
    private Button btnMinus8, btnMinus9, btnMinus10, btnMinus11, btnMinus12, btnMinus13, btnMinus14;
    private TextView quantityText8, quantityText9, quantityText10, quantityText11, quantityText12, quantityText13, quantityText14;
    private Button btnPlus8, btnPlus9, btnPlus10, btnPlus11, btnPlus12, btnPlus13, btnPlus; // Note: btnPlus instead of btnPlus14
    private Button btnAddToCart8, btnAddToCart9, btnAddToCart10, btnAddToCart11, btnAddToCart12, btnAddToCart13, btnAddToCart14;

    private Button btnViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starters_activity);

        // Initialize views for each starter item
        itemImage8 = findViewById(R.id.itemImage8);
        itemName8 = findViewById(R.id.itemName8);
        itemPrice8 = findViewById(R.id.itemPrice8);
        btnMinus8 = findViewById(R.id.btnMinus8);
        quantityText8 = findViewById(R.id.quantityText8);
        btnPlus8 = findViewById(R.id.btnPlus8);
        btnAddToCart8 = findViewById(R.id.btnAddToCart8);
        setupQuantityButtons(btnMinus8, quantityText8, btnPlus8, itemName8.getText().toString(), itemPrice8);

        itemImage9 = findViewById(R.id.itemImage9);
        itemName9 = findViewById(R.id.itemName9);
        itemPrice9 = findViewById(R.id.itemPrice9);
        btnMinus9 = findViewById(R.id.btnMinus9);
        quantityText9 = findViewById(R.id.quantityText9);
        btnPlus9 = findViewById(R.id.btnPlus9);
        btnAddToCart9 = findViewById(R.id.btnAddToCart9);
        setupQuantityButtons(btnMinus9, quantityText9, btnPlus9, itemName9.getText().toString(), itemPrice9);

        itemImage10 = findViewById(R.id.itemImage10);
        itemName10 = findViewById(R.id.itemName10);
        itemPrice10 = findViewById(R.id.itemPrice10);
        btnMinus10 = findViewById(R.id.btnMinus10);
        quantityText10 = findViewById(R.id.quantityText10);
        btnPlus10 = findViewById(R.id.btnPlus10);
        btnAddToCart10 = findViewById(R.id.btnAddToCart10);
        setupQuantityButtons(btnMinus10, quantityText10, btnPlus10, itemName10.getText().toString(), itemPrice10);

        itemImage11 = findViewById(R.id.itemImage11);
        itemName11 = findViewById(R.id.itemName11);
        itemPrice11 = findViewById(R.id.itemPrice11);
        btnMinus11 = findViewById(R.id.btnMinus11);
        quantityText11 = findViewById(R.id.quantityText11);
        btnPlus11 = findViewById(R.id.btnPlus11);
        btnAddToCart11 = findViewById(R.id.btnAddToCart11);
        setupQuantityButtons(btnMinus11, quantityText11, btnPlus11, itemName11.getText().toString(), itemPrice11);

        itemImage12 = findViewById(R.id.itemImage12);
        itemName12 = findViewById(R.id.itemName12);
        itemPrice12 = findViewById(R.id.itemPrice12);
        btnMinus12 = findViewById(R.id.btnMinus12);
        quantityText12 = findViewById(R.id.quantityText12);
        btnPlus12 = findViewById(R.id.btnPlus12);
        btnAddToCart12 = findViewById(R.id.btnAddToCart12);
        setupQuantityButtons(btnMinus12, quantityText12, btnPlus12, itemName12.getText().toString(), itemPrice12);

        itemImage13 = findViewById(R.id.itemImage13);
        itemName13 = findViewById(R.id.itemName13);
        itemPrice13 = findViewById(R.id.itemPrice13);
        btnMinus13 = findViewById(R.id.btnMinus13);
        quantityText13 = findViewById(R.id.quantityText13);
        btnPlus13 = findViewById(R.id.btnPlus13);
        btnAddToCart13 = findViewById(R.id.btnAddToCart13);
        setupQuantityButtons(btnMinus13, quantityText13, btnPlus13, itemName13.getText().toString(), itemPrice13);

        itemImage14 = findViewById(R.id.itemImage14);
        itemName14 = findViewById(R.id.itemName14);
        itemPrice14 = findViewById(R.id.itemPrice14);
        btnMinus14 = findViewById(R.id.btnMinus14);
        quantityText14 = findViewById(R.id.quantityText14);
        btnPlus = findViewById(R.id.btnPlus); // Using the correct ID
        btnAddToCart14 = findViewById(R.id.btnAddToCart14);
        btnViewCart = findViewById(R.id.btnViewCart);
        setupQuantityButtons(btnMinus14, quantityText14, btnPlus, itemName14.getText().toString(), itemPrice14);

        // 🔽 Add this block just below the last setupQuantityButtons call
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the CartActivity
                Intent intent = new Intent(StartersActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupQuantityButtons(Button minusButton, final TextView quantityTextView, Button plusButton, final String itemName, final TextView itemPriceTextView) {
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(quantityTextView.getText().toString());
                if (quantity > 0) {
                    quantity--;
                    quantityTextView.setText(String.valueOf(quantity));
                }
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(quantityTextView.getText().toString());
                quantity++;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        // Set onClickListener for the "Add to Cart" button
        Button addToCartButton = null;
        if (minusButton.getId() == R.id.btnMinus8) addToCartButton = btnAddToCart8;
        else if (minusButton.getId() == R.id.btnMinus9) addToCartButton = btnAddToCart9;
        else if (minusButton.getId() == R.id.btnMinus10) addToCartButton = btnAddToCart10;
        else if (minusButton.getId() == R.id.btnMinus11) addToCartButton = btnAddToCart11;
        else if (minusButton.getId() == R.id.btnMinus12) addToCartButton = btnAddToCart12;
        else if (minusButton.getId() == R.id.btnMinus13) addToCartButton = btnAddToCart13;
        else if (minusButton.getId() == R.id.btnMinus14) addToCartButton = btnAddToCart14;

        if (addToCartButton != null) {
            final Button finalAddToCartButton = addToCartButton;
            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantity = Integer.parseInt(quantityTextView.getText().toString());
                    if (quantity > 0) {
                        // Get the price (remove the '₹' and parse)
                        String priceString = itemPriceTextView.getText().toString().substring(1);
                        double price = Double.parseDouble(priceString);

                        // Add the item to the shared shopping cart
                        ShoppingCart.getInstance().addItem(itemName, quantity, price);

                        Toast.makeText(StartersActivity.this, quantity + " " + itemName + "(s) added to cart", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(StartersActivity.this, "Please select a quantity for " + itemName, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BeveragesActivity extends AppCompatActivity {

    // Declare views for each beverage item
    private ImageView itemImage15, itemImage16, itemImage17, itemImage18, itemImage19, itemImage20, itemImage21;
    private TextView itemName15, itemName16, itemName17, itemName18, itemName19, itemName20, itemName21;
    private TextView itemPrice15, itemPrice16, itemPrice17, itemPrice18, itemPrice19, itemPrice20, itemPrice21;
    private Button btnMinus15, btnMinus16, btnMinus17, btnMinus18, btnMinus19, btnMinus20, btnMinus21;
    private TextView quantityText15, quantityText16, quantityText17, quantityText18, quantityText19, quantityText20, quantityText21;
    private Button btnPlus15, btnPlus16, btnPlus17, btnPlus18, btnPlus19, btnPlus20, btnPlus21;
    private Button btnAddToCart15, btnAddToCart16, btnAddToCart17, btnAddToCart18, btnAddToCart19, btnAddToCart20, btnAddToCart21;

    private Button btnViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beverage_activity);

        // Initialize views for each beverage item
        itemImage15 = findViewById(R.id.itemImage15);
        itemName15 = findViewById(R.id.itemName15);
        itemPrice15 = findViewById(R.id.itemPrice15);
        btnMinus15 = findViewById(R.id.btnMinus15);
        quantityText15 = findViewById(R.id.quantityText15);
        btnPlus15 = findViewById(R.id.btnPlus15);
        btnAddToCart15 = findViewById(R.id.btnAddToCart15);
        setupQuantityButtons(btnMinus15, quantityText15, btnPlus15, itemName15.getText().toString(), itemPrice15);

        itemImage16 = findViewById(R.id.itemImage16);
        itemName16 = findViewById(R.id.itemName16);
        itemPrice16 = findViewById(R.id.itemPrice16);
        btnMinus16 = findViewById(R.id.btnMinus16);
        quantityText16 = findViewById(R.id.quantityText16);
        btnPlus16 = findViewById(R.id.btnPlus16);
        btnAddToCart16 = findViewById(R.id.btnAddToCart16);
        setupQuantityButtons(btnMinus16, quantityText16, btnPlus16, itemName16.getText().toString(), itemPrice16);

        itemImage17 = findViewById(R.id.itemImage17);
        itemName17 = findViewById(R.id.itemName17);
        itemPrice17 = findViewById(R.id.itemPrice17);
        btnMinus17 = findViewById(R.id.btnMinus17);
        quantityText17 = findViewById(R.id.quantityText17);
        btnPlus17 = findViewById(R.id.btnPlus17);
        btnAddToCart17 = findViewById(R.id.btnAddToCart17);
        setupQuantityButtons(btnMinus17, quantityText17, btnPlus17, itemName17.getText().toString(), itemPrice17);

        itemImage18 = findViewById(R.id.itemImage18);
        itemName18 = findViewById(R.id.itemName18);
        itemPrice18 = findViewById(R.id.itemPrice18);
        btnMinus18 = findViewById(R.id.btnMinus18);
        quantityText18 = findViewById(R.id.quantityText18);
        btnPlus18 = findViewById(R.id.btnPlus18);
        btnAddToCart18 = findViewById(R.id.btnAddToCart18);
        setupQuantityButtons(btnMinus18, quantityText18, btnPlus18, itemName18.getText().toString(), itemPrice18);

        itemImage19 = findViewById(R.id.itemImage19);
        itemName19 = findViewById(R.id.itemName19);
        itemPrice19 = findViewById(R.id.itemPrice19);
        btnMinus19 = findViewById(R.id.btnMinus19);
        quantityText19 = findViewById(R.id.quantityText19);
        btnPlus19 = findViewById(R.id.btnPlus19);
        btnAddToCart19 = findViewById(R.id.btnAddToCart19);
        setupQuantityButtons(btnMinus19, quantityText19, btnPlus19, itemName19.getText().toString(), itemPrice19);

        itemImage20 = findViewById(R.id.itemImage20);
        itemName20 = findViewById(R.id.itemName20);
        itemPrice20 = findViewById(R.id.itemPrice20);
        btnMinus20 = findViewById(R.id.btnMinus20);
        quantityText20 = findViewById(R.id.quantityText20);
        btnPlus20 = findViewById(R.id.btnPlus20);
        btnAddToCart20 = findViewById(R.id.btnAddToCart20);
        setupQuantityButtons(btnMinus20, quantityText20, btnPlus20, itemName20.getText().toString(), itemPrice20);

        itemImage21 = findViewById(R.id.itemImage21);
        itemName21 = findViewById(R.id.itemName21);
        itemPrice21 = findViewById(R.id.itemPrice21);
        btnMinus21 = findViewById(R.id.btnMinus21);
        quantityText21 = findViewById(R.id.quantityText21);
        btnPlus21 = findViewById(R.id.btnPlus21);
        btnAddToCart21 = findViewById(R.id.btnAddToCart21);
        btnViewCart = findViewById(R.id.btnViewCart);
        setupQuantityButtons(btnMinus21, quantityText21, btnPlus21, itemName21.getText().toString(), itemPrice21);

        // 🔽 Add this block just below the last setupQuantityButtons call
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the CartActivity
                Intent intent = new Intent(BeveragesActivity.this, CartActivity.class);
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
        if (minusButton.getId() == R.id.btnMinus15) addToCartButton = btnAddToCart15;
        else if (minusButton.getId() == R.id.btnMinus16) addToCartButton = btnAddToCart16;
        else if (minusButton.getId() == R.id.btnMinus17) addToCartButton = btnAddToCart17;
        else if (minusButton.getId() == R.id.btnMinus18) addToCartButton = btnAddToCart18;
        else if (minusButton.getId() == R.id.btnMinus19) addToCartButton = btnAddToCart19;
        else if (minusButton.getId() == R.id.btnMinus20) addToCartButton = btnAddToCart20;
        else if (minusButton.getId() == R.id.btnMinus21) addToCartButton = btnAddToCart21;

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

                        Toast.makeText(BeveragesActivity.this, quantity + " " + itemName + "(s) added to cart", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BeveragesActivity.this, "Please select a quantity for " + itemName, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
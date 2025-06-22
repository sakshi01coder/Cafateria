package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCourseActivity extends AppCompatActivity {

    // Declare views for each beverage item
    private ImageView itemImage33, itemImage34, itemImage35,itemImage36,itemImage37,itemImage38,itemImage39;
    private TextView itemName33, itemName34, itemName35,itemName36,itemName37,itemName38,itemName39;
    private TextView  itemPrice33, itemPrice34, itemPrice35,itemPrice36,itemPrice37,itemPrice38,itemPrice39;
    private Button btnMinus33, btnMinus34, btnMinus35, btnMinus36, btnMinus37, btnMinus38, btnMinus39;;
    private TextView  quantityText33, quantityText34, quantityText35, quantityText36, quantityText37,quantityText38, quantityText39;
    private Button  btnPlus33, btnPlus34, btnPlus35, btnPlus36, btnPlus37, btnPlus38, btnPlus39;
    private Button  btnAddToCart33, btnAddToCart34, btnAddToCart35, btnAddToCart36, btnAddToCart37, btnAddToCart38, btnAddToCart39;

    private Button btnViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincourse_activity);

        itemImage33 = findViewById(R.id.itemImage33);
        itemName33 = findViewById(R.id.itemName33);
        itemPrice33 = findViewById(R.id.itemPrice33);
        btnMinus33 = findViewById(R.id.btnMinus33);
        quantityText33 = findViewById(R.id.quantityText33);
        btnPlus33 = findViewById(R.id.btnPlus33);
        btnAddToCart33 = findViewById(R.id.btnAddToCart33);
        setupQuantityButtons(btnMinus33, quantityText33, btnPlus33, itemName33.getText().toString(), itemPrice33);

        itemImage34 = findViewById(R.id.itemImage34);
        itemName34 = findViewById(R.id.itemName34);
        itemPrice34 = findViewById(R.id.itemPrice34);
        btnMinus34 = findViewById(R.id.btnMinus34);
        quantityText34 = findViewById(R.id.quantityText34);
        btnPlus34 = findViewById(R.id.btnPlus34);
        btnAddToCart34 = findViewById(R.id.btnAddToCart34);
        setupQuantityButtons(btnMinus34, quantityText34, btnPlus34, itemName34.getText().toString(), itemPrice34);

        itemImage35 = findViewById(R.id.itemImage35);
        itemName35 = findViewById(R.id.itemName35);
        itemPrice35 = findViewById(R.id.itemPrice35);
        btnMinus35 = findViewById(R.id.btnMinus35);
        quantityText35 = findViewById(R.id.quantityText35);
        btnPlus35 = findViewById(R.id.btnPlus35);
        btnAddToCart35 = findViewById(R.id.btnAddToCart35);
        setupQuantityButtons(btnMinus35, quantityText35, btnPlus35, itemName35.getText().toString(), itemPrice35);

        itemImage36 = findViewById(R.id.itemImage36);
        itemName36 = findViewById(R.id.itemName36);
        itemPrice36 = findViewById(R.id.itemPrice36);
        btnMinus36 = findViewById(R.id.btnMinus36);
        quantityText36 = findViewById(R.id.quantityText36);
        btnPlus36 = findViewById(R.id.btnPlus36);
        btnAddToCart36 = findViewById(R.id.btnAddToCart36);
        setupQuantityButtons(btnMinus36, quantityText36, btnPlus36, itemName36.getText().toString(), itemPrice36);

        itemImage37 = findViewById(R.id.itemImage37);
        itemName37 = findViewById(R.id.itemName37);
        itemPrice37 = findViewById(R.id.itemPrice37);
        btnMinus37 = findViewById(R.id.btnMinus37);
        quantityText37 = findViewById(R.id.quantityText37);
        btnPlus37 = findViewById(R.id.btnPlus37);
        btnAddToCart37 = findViewById(R.id.btnAddToCart37);
        setupQuantityButtons(btnMinus37, quantityText37, btnPlus37, itemName37.getText().toString(), itemPrice37);

        itemImage38 = findViewById(R.id.itemImage38);
        itemName38 = findViewById(R.id.itemName38);
        itemPrice38 = findViewById(R.id.itemPrice38);
        btnMinus38 = findViewById(R.id.btnMinus38);
        quantityText38 = findViewById(R.id.quantityText38);
        btnPlus38 = findViewById(R.id.btnPlus38);
        btnAddToCart38 = findViewById(R.id.btnAddToCart38);
        setupQuantityButtons(btnMinus38, quantityText38, btnPlus38, itemName38.getText().toString(), itemPrice38);

        itemImage39 = findViewById(R.id.itemImage39);
        itemName39 = findViewById(R.id.itemName39);
        itemPrice39 = findViewById(R.id.itemPrice39);
        btnMinus39 = findViewById(R.id.btnMinus39);
        quantityText39 = findViewById(R.id.quantityText39);
        btnPlus39 = findViewById(R.id.btnPlus39);
        btnAddToCart39 = findViewById(R.id.btnAddToCart39);
        setupQuantityButtons(btnMinus39, quantityText39, btnPlus39, itemName39.getText().toString(), itemPrice39);

        // 🔽 Add this block just below the last setupQuantityButtons call
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the CartActivity
                Intent intent = new Intent(MainCourseActivity.this, CartActivity.class);
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
        if (minusButton.getId() == R.id.btnMinus33) addToCartButton = btnAddToCart33;
        else if (minusButton.getId() == R.id.btnMinus34) addToCartButton = btnAddToCart34;
        else if (minusButton.getId() == R.id.btnMinus35) addToCartButton = btnAddToCart35;
        else if (minusButton.getId() == R.id.btnMinus36) addToCartButton = btnAddToCart36;
        else if (minusButton.getId() == R.id.btnMinus37) addToCartButton = btnAddToCart37;
        else if (minusButton.getId() == R.id.btnMinus38) addToCartButton = btnAddToCart38;
        else if (minusButton.getId() == R.id.btnMinus39) addToCartButton = btnAddToCart39;

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

                        Toast.makeText(MainCourseActivity.this, quantity + " " + itemName + "(s) added to cart", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainCourseActivity.this, "Please select a quantity for " + itemName, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
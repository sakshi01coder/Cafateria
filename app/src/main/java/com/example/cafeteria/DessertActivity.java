package com.example.cafeteria;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DessertActivity extends AppCompatActivity {

    // Declare views for each dessert item
    private ImageView itemImage22, itemImage23, itemImage24, itemImage25, itemImage26, itemImage27, itemImage28;
    private TextView itemName22, itemName23, itemName24, itemName25, itemName26, itemName27, itemName28;
    private TextView itemPrice22, itemPrice23, itemPrice24, itemPrice25, itemPrice26, itemPrice27, itemPrice28;
    private Button btnMinus22, btnMinus23, btnMinus24, btnMinus25, btnMinus26, btnMinus27, btnMinus28;
    private TextView quantityText22, quantityText23, quantityText24, quantityText25, quantityText26, quantityText27, quantityText28;
    private Button btnPlus22, btnPlus23, btnPlus24, btnPlus25, btnPlus26, btnPlus27, btnPlus28;
    private Button btnAddToCart22, btnAddToCart23, btnAddToCart24, btnAddToCart25, btnAddToCart26, btnAddToCart27, btnAddToCart28;
    private Button btnViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dessert_activity);

        // Initialize views for each dessert item
        itemImage22 = findViewById(R.id.itemImage22);
        itemName22 = findViewById(R.id.itemName22);
        itemPrice22 = findViewById(R.id.itemPrice22);
        btnMinus22 = findViewById(R.id.btnMinus22);
        quantityText22 = findViewById(R.id.quantityText22);
        btnPlus22 = findViewById(R.id.btnPlus22);
        btnAddToCart22 = findViewById(R.id.btnAddToCart22);
        setupQuantityButtons(btnMinus22, quantityText22, btnPlus22, itemName22.getText().toString(), itemPrice22);

        itemImage23 = findViewById(R.id.itemImage23);
        itemName23 = findViewById(R.id.itemName23);
        itemPrice23 = findViewById(R.id.itemPrice23);
        btnMinus23 = findViewById(R.id.btnMinus23);
        quantityText23 = findViewById(R.id.quantityText23);
        btnPlus23 = findViewById(R.id.btnPlus23);
        btnAddToCart23 = findViewById(R.id.btnAddToCart23);
        setupQuantityButtons(btnMinus23, quantityText23, btnPlus23, itemName23.getText().toString(), itemPrice23);

        itemImage24 = findViewById(R.id.itemImage24);
        itemName24 = findViewById(R.id.itemName24);
        itemPrice24 = findViewById(R.id.itemPrice24);
        btnMinus24 = findViewById(R.id.btnMinus24);
        quantityText24 = findViewById(R.id.quantityText24);
        btnPlus24 = findViewById(R.id.btnPlus24);
        btnAddToCart24 = findViewById(R.id.btnAddToCart24);
        setupQuantityButtons(btnMinus24, quantityText24, btnPlus24, itemName24.getText().toString(), itemPrice24);

        itemImage25 = findViewById(R.id.itemImage25);
        itemName25 = findViewById(R.id.itemName25);
        itemPrice25 = findViewById(R.id.itemPrice25);
        btnMinus25 = findViewById(R.id.btnMinus25);
        quantityText25 = findViewById(R.id.quantityText25);
        btnPlus25 = findViewById(R.id.btnPlus25);
        btnAddToCart25 = findViewById(R.id.btnAddToCart25);
        setupQuantityButtons(btnMinus25, quantityText25, btnPlus25, itemName25.getText().toString(), itemPrice25);

        itemImage26 = findViewById(R.id.itemImage26);
        itemName26 = findViewById(R.id.itemName26);
        itemPrice26 = findViewById(R.id.itemPrice26);
        btnMinus26 = findViewById(R.id.btnMinus26);
        quantityText26 = findViewById(R.id.quantityText26);
        btnPlus26 = findViewById(R.id.btnPlus26);
        btnAddToCart26 = findViewById(R.id.btnAddToCart26);
        setupQuantityButtons(btnMinus26, quantityText26, btnPlus26, itemName26.getText().toString(), itemPrice26);

        itemImage27 = findViewById(R.id.itemImage27);
        itemName27 = findViewById(R.id.itemName27);
        itemPrice27 = findViewById(R.id.itemPrice27);
        btnMinus27 = findViewById(R.id.btnMinus27);
        quantityText27 = findViewById(R.id.quantityText27);
        btnPlus27 = findViewById(R.id.btnPlus27);
        btnAddToCart27 = findViewById(R.id.btnAddToCart27);
        setupQuantityButtons(btnMinus27, quantityText27, btnPlus27, itemName27.getText().toString(), itemPrice27);

        itemImage28 = findViewById(R.id.itemImage28);
        itemName28 = findViewById(R.id.itemName28);
        itemPrice28 = findViewById(R.id.itemPrice28);
        btnMinus28 = findViewById(R.id.btnMinus28);
        quantityText28 = findViewById(R.id.quantityText28);
        btnPlus28 = findViewById(R.id.btnPlus28);
        btnAddToCart28 = findViewById(R.id.btnAddToCart28);
        btnViewCart = findViewById(R.id.btnViewCart);
        setupQuantityButtons(btnMinus28, quantityText28, btnPlus28, itemName28.getText().toString(), itemPrice28);

        // 🔽 Add this block just below the last setupQuantityButtons call
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the CartActivity
                Intent intent = new Intent(DessertActivity.this, CartActivity.class);
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
        if (minusButton.getId() == R.id.btnMinus22) addToCartButton = btnAddToCart22;
        else if (minusButton.getId() == R.id.btnMinus23) addToCartButton = btnAddToCart23;
        else if (minusButton.getId() == R.id.btnMinus24) addToCartButton = btnAddToCart24;
        else if (minusButton.getId() == R.id.btnMinus25) addToCartButton = btnAddToCart25;
        else if (minusButton.getId() == R.id.btnMinus26) addToCartButton = btnAddToCart26;
        else if (minusButton.getId() == R.id.btnMinus27) addToCartButton = btnAddToCart27;
        else if (minusButton.getId() == R.id.btnMinus28) addToCartButton = btnAddToCart28;

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

                        Toast.makeText(DessertActivity.this, quantity + " " + itemName + "(s) added to cart", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DessertActivity.this, "Please select a quantity for " + itemName, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
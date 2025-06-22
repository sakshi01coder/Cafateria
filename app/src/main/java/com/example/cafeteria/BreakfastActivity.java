package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BreakfastActivity extends AppCompatActivity {

    private EditText searchBar;

    private LinearLayout layoutItem1, layoutItem2, layoutItem3, layoutItem4, layoutItem5, layoutItem6, layoutItem7;

    private TextView itemName1, itemName2, itemName3, itemName4, itemName5, itemName6, itemName7;
    private TextView itemPrice1, itemPrice2, itemPrice3, itemPrice4, itemPrice5, itemPrice6, itemPrice7;
    private Button btnMinus1, btnMinus2, btnMinus3, btnMinus4, btnMinus5, btnMinus6, btnMinus7;
    private TextView quantityText1, quantityText2, quantityText3, quantityText4, quantityText5, quantityText6, quantityText7;
    private Button btnPlus1, btnPlus2, btnPlus3, btnPlus4, btnPlus5, btnPlus6, btnPlus7;
    private Button btnAddToCart1, btnAddToCart2, btnAddToCart3, btnAddToCart4, btnAddToCart5, btnAddToCart6, btnAddToCart7;

    private Button btnViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast_activity);

        searchBar = findViewById(R.id.searchBar);

        // Layout containers for each item (make sure you wrap each item block in XML in a LinearLayout and assign proper IDs)
        layoutItem1 = findViewById(R.id.layoutItem1);
        layoutItem2 = findViewById(R.id.layoutItem2);
        layoutItem3 = findViewById(R.id.layoutItem3);
        layoutItem4 = findViewById(R.id.layoutItem4);
        layoutItem5 = findViewById(R.id.layoutItem5);
        layoutItem6 = findViewById(R.id.layoutItem6);
        layoutItem7 = findViewById(R.id.layoutItem7);

        // Initialize views
        itemName1 = findViewById(R.id.itemName1);
        itemPrice1 = findViewById(R.id.itemPrice1);
        btnMinus1 = findViewById(R.id.btnMinus1);
        quantityText1 = findViewById(R.id.quantityText1);
        btnPlus1 = findViewById(R.id.btnPlus1);
        btnAddToCart1 = findViewById(R.id.btnAddToCart1);
        setupQuantityButtons(btnMinus1, quantityText1, btnPlus1, itemName1.getText().toString(), itemPrice1);

        itemName2 = findViewById(R.id.itemName2);
        itemPrice2 = findViewById(R.id.itemPrice2);
        btnMinus2 = findViewById(R.id.btnMinus2);
        quantityText2 = findViewById(R.id.quantityText2);
        btnPlus2 = findViewById(R.id.btnPlus2);
        btnAddToCart2 = findViewById(R.id.btnAddToCart2);
        setupQuantityButtons(btnMinus2, quantityText2, btnPlus2, itemName2.getText().toString(), itemPrice2);

        itemName3 = findViewById(R.id.itemName3);
        itemPrice3 = findViewById(R.id.itemPrice3);
        btnMinus3 = findViewById(R.id.btnMinus3);
        quantityText3 = findViewById(R.id.quantityText3);
        btnPlus3 = findViewById(R.id.btnPlus3);
        btnAddToCart3 = findViewById(R.id.btnAddToCart3);
        setupQuantityButtons(btnMinus3, quantityText3, btnPlus3, itemName3.getText().toString(), itemPrice3);

        itemName4 = findViewById(R.id.itemName4);
        itemPrice4 = findViewById(R.id.itemPrice4);
        btnMinus4 = findViewById(R.id.btnMinus4);
        quantityText4 = findViewById(R.id.quantityText4);
        btnPlus4 = findViewById(R.id.btnPlus4);
        btnAddToCart4 = findViewById(R.id.btnAddToCart4);
        setupQuantityButtons(btnMinus4, quantityText4, btnPlus4, itemName4.getText().toString(), itemPrice4);

        itemName5 = findViewById(R.id.itemName5);
        itemPrice5 = findViewById(R.id.itemPrice5);
        btnMinus5 = findViewById(R.id.btnMinus5);
        quantityText5 = findViewById(R.id.quantityText5);
        btnPlus5 = findViewById(R.id.btnPlus5);
        btnAddToCart5 = findViewById(R.id.btnAddToCart5);
        setupQuantityButtons(btnMinus5, quantityText5, btnPlus5, itemName5.getText().toString(), itemPrice5);

        itemName6 = findViewById(R.id.itemName6);
        itemPrice6 = findViewById(R.id.itemPrice6);
        btnMinus6 = findViewById(R.id.btnMinus6);
        quantityText6 = findViewById(R.id.quantityText6);
        btnPlus6 = findViewById(R.id.btnPlus6);
        btnAddToCart6 = findViewById(R.id.btnAddToCart6);
        setupQuantityButtons(btnMinus6, quantityText6, btnPlus6, itemName6.getText().toString(), itemPrice6);

        itemName7 = findViewById(R.id.itemName7);
        itemPrice7 = findViewById(R.id.itemPrice7);
        btnMinus7 = findViewById(R.id.btnMinus7);
        quantityText7 = findViewById(R.id.quantityText7);
        btnPlus7 = findViewById(R.id.btnPlus7);
        btnAddToCart7 = findViewById(R.id.btnAddToCart7);
        btnViewCart = findViewById(R.id.btnViewCart);
        setupQuantityButtons(btnMinus7, quantityText7, btnPlus7, itemName7.getText().toString(), itemPrice7);

        // 🔽 Add this block just below the last setupQuantityButtons call
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the CartActivity
                Intent intent = new Intent(BreakfastActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        // 🔍 Setup search functionality
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterItems(s.toString());
            }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    // 🔍 Filter function for search bar
    private void filterItems(String query) {
        query = query.toLowerCase();

        toggleItemVisibility(layoutItem1, itemName1, query);
        toggleItemVisibility(layoutItem2, itemName2, query);
        toggleItemVisibility(layoutItem3, itemName3, query);
        toggleItemVisibility(layoutItem4, itemName4, query);
        toggleItemVisibility(layoutItem5, itemName5, query);
        toggleItemVisibility(layoutItem6, itemName6, query);
        toggleItemVisibility(layoutItem7, itemName7, query);
    }

    private void toggleItemVisibility(LinearLayout layout, TextView nameView, String query) {
        String name = nameView.getText().toString().toLowerCase();
        if (name.contains(query)) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    private void setupQuantityButtons(Button minusButton, final TextView quantityTextView, Button plusButton, final String itemName, final TextView itemPriceTextView) {
        minusButton.setOnClickListener(v -> {
            int quantity = Integer.parseInt(quantityTextView.getText().toString());
            if (quantity > 0) {
                quantity--;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        plusButton.setOnClickListener(v -> {
            int quantity = Integer.parseInt(quantityTextView.getText().toString());
            quantity++;
            quantityTextView.setText(String.valueOf(quantity));
        });

        Button addToCartButton = null;
        if (minusButton.getId() == R.id.btnMinus1) addToCartButton = btnAddToCart1;
        else if (minusButton.getId() == R.id.btnMinus2) addToCartButton = btnAddToCart2;
        else if (minusButton.getId() == R.id.btnMinus3) addToCartButton = btnAddToCart3;
        else if (minusButton.getId() == R.id.btnMinus4) addToCartButton = btnAddToCart4;
        else if (minusButton.getId() == R.id.btnMinus5) addToCartButton = btnAddToCart5;
        else if (minusButton.getId() == R.id.btnMinus6) addToCartButton = btnAddToCart6;
        else if (minusButton.getId() == R.id.btnMinus7) addToCartButton = btnAddToCart7;

        if (addToCartButton != null) {
            final Button finalAddToCartButton = addToCartButton;
            addToCartButton.setOnClickListener(v -> {
                int quantity = Integer.parseInt(quantityTextView.getText().toString());
                if (quantity > 0) {
                    String priceString = itemPriceTextView.getText().toString().substring(1);
                    double price = Double.parseDouble(priceString);
                    ShoppingCart.getInstance().addItem(itemName, quantity, price);
                    Toast.makeText(BreakfastActivity.this, quantity + " " + itemName + "(s) added to cart", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BreakfastActivity.this, "Please select a quantity for " + itemName, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
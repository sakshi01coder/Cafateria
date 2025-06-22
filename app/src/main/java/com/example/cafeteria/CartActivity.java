package com.example.cafeteria;
// CartActivity.java


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    private LinearLayout cartItemsLayout;
    private TextView totalAmountTextView;
    private Button proceedToPaymentButton;
    private ShoppingCart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);

        cartItemsLayout = findViewById(R.id.cartItemsLayout);
        totalAmountTextView = findViewById(R.id.totalAmountTextView);
        proceedToPaymentButton = findViewById(R.id.proceedToPaymentButton);

        // Get the instance of the ShoppingCart
        cart = ShoppingCart.getInstance();

        // Display the cart items
        displayCartItems();

        // Set up the "Proceed to Payment" button click listener
        proceedToPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if there are items in the cart before proceeding to payment
                if (!cart.getAllItems().isEmpty()) {
                    // In a real application, you would navigate to your payment activity here
                    // and potentially pass the total amount or the list of items.
                    double totalAmount = cart.getTotalPrice();
                    Intent paymentIntent = new Intent(CartActivity.this, PaymentActivity.class);
                    paymentIntent.putExtra("totalAmount", totalAmount); // Pass the total amount
                    // You could also pass the list of items if needed:
                    // paymentIntent.putParcelableArrayListExtra("cartItems", (ArrayList<ShoppingCart.CartItem>) cart.getAllItems());
                    startActivity(paymentIntent);
                } else {
                    Toast.makeText(CartActivity.this, "Your cart is empty. Please add items to proceed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the cart display every time the activity resumes
        displayCartItems();
    }

    private void displayCartItems() {
        cartItemsLayout.removeAllViews();
        List<ShoppingCart.CartItem> cartItems = cart.getAllItems();
        double totalAmount = 0;

        if (cartItems.isEmpty()) {
            TextView emptyCartMessage = new TextView(this);
            emptyCartMessage.setText("Your cart is empty.");
            emptyCartMessage.setTextSize(18);
            cartItemsLayout.addView(emptyCartMessage);
            proceedToPaymentButton.setEnabled(false);
        } else {
            proceedToPaymentButton.setEnabled(true);
            LayoutInflater inflater = LayoutInflater.from(this);

            for (ShoppingCart.CartItem cartItem : cartItems) {
                View itemView = inflater.inflate(R.layout.cart_item_row, cartItemsLayout, false);

                TextView itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
                TextView itemPriceTextView = itemView.findViewById(R.id.itemPriceTextView);
                TextView itemQuantityTextView = itemView.findViewById(R.id.itemQuantityTextView);
                Button removeButton = itemView.findViewById(R.id.removeButton);

                itemNameTextView.setText(cartItem.getName());
                itemPriceTextView.setText(cartItem.getFormattedPrice());
                itemQuantityTextView.setText("Qty: " + cartItem.getQuantity());

                removeButton.setOnClickListener(v -> {
                    cart.removeItem(cartItem.getName());
                    displayCartItems(); // Update the UI after removing the item
                    Toast.makeText(this, cartItem.getName() + " removed from cart", Toast.LENGTH_SHORT).show();
                });

                cartItemsLayout.addView(itemView);
                totalAmount += cartItem.getPrice() * cartItem.getQuantity();
            }
        }

        totalAmountTextView.setText("Total: " + String.format(Locale.getDefault(), "₹%.2f", totalAmount));
    }
}
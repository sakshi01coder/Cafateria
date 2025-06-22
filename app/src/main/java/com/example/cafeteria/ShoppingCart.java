package com.example.cafeteria;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoppingCart {

    private static ShoppingCart instance;
    private List<CartItem> items;

    private ShoppingCart() {
        items = new ArrayList<>();
    }

    public static synchronized ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(String name, int quantity, double price) {
        for (CartItem item : items) {
            if (item.getName().equals(name)) {
                item.incrementQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(name, quantity, price));
    }

    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                return;
            }
        }
    }

    public void updateQuantity(String name, int newQuantity) {
        for (CartItem item : items) {
            if (item.getName().equals(name)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
    }

    public List<CartItem> getAllItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void clearCart() {
        items.clear();
    }

    // Inner class to represent an item in the cart
    public static class CartItem {
        private String name;
        private int quantity;
        private double price;

        public CartItem(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void incrementQuantity(int quantity) {
            this.quantity += quantity;
        }

        public String getFormattedPrice() {
            return String.format(Locale.getDefault(), "₹%.2f", price);
        }

        public String getTotalItemPriceFormatted() {
            return String.format(Locale.getDefault(), "₹%.2f", price * quantity);
        }
    }
}
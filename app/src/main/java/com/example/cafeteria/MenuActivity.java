package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView categoryTitle;
    Button btnBreakfast, btnStarters, btnMainCourse, btnDessert, btnBeverages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        // Get the selected category name from Intent
        String category = getIntent().getStringExtra("CATEGORY");

        // Set title to match the selected category
        categoryTitle = findViewById(R.id.categoryTitle);
        categoryTitle.setText(category + " Menu");



        // Check if the category is "All"
        if ("All".equalsIgnoreCase(category)) {
            // TODO: Populate menuList with all items across all categories
            // For now, just show a toast (for demo purpose)
            Toast.makeText(this, "Showing full menu across all categories", Toast.LENGTH_SHORT).show();
        }

        // Initialize buttons
        btnBreakfast = findViewById(R.id.btnBreakfast);
        btnStarters = findViewById(R.id.btnStarters);
        btnMainCourse = findViewById(R.id.btnMainCourse);
        btnDessert = findViewById(R.id.btnDessert);
        btnBeverages = findViewById(R.id.btnBeverages);

        // Set click listeners for each button
        btnBreakfast.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, BreakfastActivity.class);
            startActivity(intent);
        });

        btnStarters.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, StartersActivity.class);
            startActivity(intent);
        });

        btnMainCourse.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, MainCourseActivity.class);
            startActivity(intent);
        });

        btnDessert.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, DessertActivity.class);
            startActivity(intent);
        });

        btnBeverages.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, BeveragesActivity.class);
            startActivity(intent);
        });
    }
}

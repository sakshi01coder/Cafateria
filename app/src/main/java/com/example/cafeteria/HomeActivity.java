package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView greetingText;
    ViewPager2 viewPager;
    EditText searchEditText;
    GridLayout categoryGrid;
    Button checkoutButton;

    String[] categories = {"Breakfast", "Starter", "Main Course", "Dessert", "Beverage"};
    int[] categoryIcons = {
            R.drawable.breakfast, R.drawable.starter, R.drawable.main_course,
            R.drawable.dessert, R.drawable.beverage
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Get username passed from AuthActivity
        String username = getIntent().getStringExtra("USERNAME");

        // Set greeting
        greetingText = findViewById(R.id.greetingText);
        greetingText.setText("Hi " + username + "!");

        // Set up image slider
        viewPager = findViewById(R.id.imageSlider);
        List<Integer> images = Arrays.asList(
                R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4
        );
        viewPager.setAdapter(new ImageSliderAdapter(images));

        // Set up "Check Out" button
        checkoutButton = findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
            intent.putExtra("CATEGORY", "All");
            startActivity(intent);
        });

        // Set up search bar
        searchEditText = findViewById(R.id.searchEditText);

        // Set up category grid and click listener
        categoryGrid = findViewById(R.id.categoryGrid);
        for (int i = 0; i < categoryGrid.getChildCount(); i++) {
            final int index = i;
            View categoryItem = categoryGrid.getChildAt(i);
            categoryItem.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                intent.putExtra("CATEGORY", categories[index]);
                startActivity(intent);
            });
        }
    }
}

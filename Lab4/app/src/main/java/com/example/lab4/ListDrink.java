package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListDrink extends AppCompatActivity {
    ListView listView;
    ArrayList<Item>arrDrink;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_drink);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Mappings();
        adapter= new CustomAdapter(this, R.layout.activity_custom_adapter, arrDrink);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Item selectedDrink = arrDrink.get(position);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("selectedDrink", selectedDrink.getName());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void Mappings() {
        listView =findViewById(R.id.FruitList);
        arrDrink = new ArrayList<>();

        arrDrink.add(new Item("Coca", "Good way to protect your health", R.drawable.coca));
        arrDrink.add(new Item("Number1", "Orange is a good way to provide vitamin C", R.drawable.coca));
        arrDrink.add(new Item("RedBull", "Strawberry is a good for your skin", R.drawable.coca));
        arrDrink.add(new Item("PinkBull", "Spicy can make you hot in your health", R.drawable.coca));
        arrDrink.add(new Item("Arigatou", "Starfruit has beautiful view", R.drawable.coca));
        arrDrink.add(new Item("Doctor Thank", "Banana is yellow and good to eat", R.drawable.coca));
    }
}
package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class TypesOfNutrition extends AppCompatActivity {

    ListView lstTypes;
    private ArrayAdapter<String> Types;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_types_of_nutrition);

        lstTypes = findViewById(R.id.lstTypes);

        Intent intent = getIntent();

        ArrayList<String> typeslist = intent.getStringArrayListExtra("typesList");

        String selectedGoals = intent.getStringExtra("selectedGoals");

        if(typeslist != null){
            Types = new ArrayAdapter<>(TypesOfNutrition.this,android.R.layout.simple_list_item_1, typeslist);
            lstTypes.setAdapter(Types);
        }

        lstTypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent1 = new Intent(TypesOfNutrition.this,Plan.class);
                    intent1.putStringArrayListExtra("typesList", new ArrayList<>(typeslist));
                    intent1.putExtra("selectedGoals",selectedGoals);
                    startActivity(intent1);
            }
        });
    }
}
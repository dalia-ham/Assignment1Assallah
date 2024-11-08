package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Plan extends AppCompatActivity {
    TextView cell1, cell2, cell3, cell4, cell5, cell6, cell7,
            cell8, cell9, cell10, cell11, cell12, cell13, cell14,
            cell15, cell16, cell17, cell18, cell19, cell20, cell21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_plan);

        cell1 = findViewById(R.id.cell1);
        cell2 = findViewById(R.id.cell2);
        cell3 = findViewById(R.id.cell3);
        cell4 = findViewById(R.id.cell4);
        cell5 = findViewById(R.id.cell5);
        cell6 = findViewById(R.id.cell6);
        cell7 = findViewById(R.id.cell7);
        cell8 = findViewById(R.id.cell8);
        cell9 = findViewById(R.id.cell9);
        cell10 = findViewById(R.id.cell10);
        cell11 = findViewById(R.id.cell11);
        cell12 = findViewById(R.id.cell12);
        cell13 = findViewById(R.id.cell13);
        cell14 = findViewById(R.id.cell14);
        cell15 = findViewById(R.id.cell15);
        cell16 = findViewById(R.id.cell16);
        cell17 = findViewById(R.id.cell17);
        cell18 = findViewById(R.id.cell18);
        cell19 = findViewById(R.id.cell19);
        cell20 = findViewById(R.id.cell20);
        cell21 = findViewById(R.id.cell21);

        Intent intent = getIntent();
        List<String> selectedMealPlan = intent.getStringArrayListExtra("typesList");
        String selectedGoal = intent.getStringExtra("selectedGoals");
        Data(selectedMealPlan, selectedGoal);

    }
    private void Data(List<String> selectedMealPlan, String selectedGoal) {
        if (selectedMealPlan != null && !selectedMealPlan.isEmpty()) {
            if (selectedGoal != null && selectedGoal.equals("فقدان الوزن")) {
                if (selectedMealPlan.size() >= 3) {
                    cell1.setText(selectedMealPlan.get(0));
                    cell4.setText(selectedMealPlan.get(1));
                    cell7.setText(selectedMealPlan.get(2));
                    cell10.setText(selectedMealPlan.get(3));
                    cell13.setText(selectedMealPlan.get(4));
                    cell16.setText(selectedMealPlan.get(5));
                    cell19.setText(selectedMealPlan.get(6));
                } else {
                    Toast.makeText(Plan.this, "Insufficient meal data", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Plan.this, "Selected goal does not match", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Plan.this, "Selected meal plan is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
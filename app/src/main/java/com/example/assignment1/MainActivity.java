package com.example.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtAge, edtHigh, edtWeight, edtResult;
    TextView txtResult;
    RadioGroup radioGroup;
    RadioButton rbFemale, rbMale;
    Spinner spinnerGoals;
    Button btCreatePlan, btCalculate;
    private List<Tableinfo> tableInfo;
    private List<food> food1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initialize();
        edtAge = findViewById(R.id.edtAge);
        edtHigh = findViewById(R.id.edtHigh);
        edtWeight = findViewById(R.id.edtWeight);
        txtResult = findViewById(R.id.txtResult);
        radioGroup = findViewById(R.id.radioGroup);
        rbFemale = findViewById(R.id.rbFemale);
        rbMale = findViewById(R.id.rbMale);
        spinnerGoals = findViewById(R.id.spinnerGoals);
        btCreatePlan = findViewById(R.id.btCreatePlan);
        btCalculate = findViewById(R.id.btCalc);

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = "";
                if(rbFemale.isChecked()){
                    gender = "female";
                }else if(rbMale.isChecked()){
                    gender = "male";
                }
                calculateBMI(gender);
            }

        });

        List<String> goalsList = new ArrayList<>();
        for (Tableinfo info : tableInfo) {
            if (!goalsList.contains(info.getGoals())) {
                goalsList.add(info.getGoals());
            }
        }


        List<String> typesList = new ArrayList<>();
        for (Tableinfo info : tableInfo) {
            if (!typesList.contains(info.getTypes())) {
                typesList.add(info.getTypes());
            }
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, goalsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGoals.setAdapter(adapter);



        btCreatePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGoals = spinnerGoals.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this,TypesOfNutrition.class);
                intent.putStringArrayListExtra("typesList", new ArrayList<>(typesList));
                intent.putExtra("selectedGoals",selectedGoals);
                startActivity(intent);

            }
        });
    }

    private void calculateBMI(String gender){
        Double BMI = ( Double.parseDouble(edtWeight.getText().toString())/( Double.parseDouble(edtHigh.getText().toString()) *  Double.parseDouble(edtHigh.getText().toString())));
        if(gender == "female"){
            if(BMI < 18.5){
                txtResult.setText("نقص في الوزن اختار على زيادة الوزن لانشاء جدول غذائي مناسب");
            }else if(BMI >= 18.5 && BMI <= 23.9){
                txtResult.setText("وزن طبيعي");
            }else if(BMI >= 24.0){
                txtResult.setText("سمنة اختار فقدان الوزن لإنشاء جدول غذائي مناسب");
            }
        }else if(gender == "male"){
            if(BMI < 18.5){
                txtResult.setText("نقص في الوزن اختار على زيادة الوزن لانشاء جدول غذائي مناسب");
            }else if(BMI >= 18.5 && BMI <= 24.9){
                txtResult.setText("وزن طبيعي");
            }else if(BMI >= 25){
                txtResult.setText("سمنة اختار فقدان الوزن لإنشاء جدول غذائي مناسب");
            }
        }
    }

    private void initialize(){
        tableInfo = new ArrayList<>();
        food1 = new ArrayList<>();
        tableInfo.add(new Tableinfo("فقدان الوزن","نباتي",List.of(
                new food("فطور",List.of(
                        "الشوفان مع الفواكه والمكسرات",
                        "التوست الكامل مع الأفوكادو والخضار",
                        "عصير الخضروات والفواكه الأخضر",
                        "بودينغ الشيا بالفواكه",
                        "سموثي البروتين النباتي",
                        "حمص بالحبوب الكاملة والخضار",
                        "زبادي نباتي مع بذور الكتان والفواكه"
                )))));




        tableInfo.add(new Tableinfo("فقدان الوزن","خالٍ من الجلوتين",List.of(
                new food("فطور",List.of(
                        "الشوفان الليلي بالفواكه",
                        "توست الأفوكادو مع الخضار",
                        "بودينغ الشيا بالفواكه",
                        "عصير السموثي الأخضر",
                        "فطائر الحبوب الكاملة مع زبدة المكسرات",
                        "زبادي نباتي مع المكسرات والفواكه",
                        "بودينغ بذور الكتان بالفواكه"
                ))
        )));

        tableInfo.add(new Tableinfo("فقدان الوزن","منخفض الكربوهيدرات",List.of(
                new food("فطور",List.of(
                        "بيض بالأفوكادو والخضار",
                        "أومليت الخضار",
                        "توست الأفوكادو على خبز منخفض الكربوهيدرات",
                        "زبادي يوناني كامل الدسم مع المكسرات",
                        "سموثي البروتين بالخضار",
                        "توست الأفوكادو مع البيض المسلوق",
                        "سلطة تونة أو سلمون مع الأفوكادو",
                        "فطائر البيض بالخضار",
                        "بودينغ بذور الشيا مع حليب اللوز"
                ))
        )));

        tableInfo.add(new Tableinfo("فقدان الوزن","نباتي",List.of(
                new food("غداء",List.of(
                        "لفائف الخضروات",
                        "سلطة الحبوب",
                        "الحساء النباتي",
                        "اللفائف النباتية",
                        "البروتين النباتي",
                        "المعكرونة الكاملة مع الصلصة النباتية",
                        "ساندويتش الحمص"
                ))
        )));

        tableInfo.add(new Tableinfo("فقدان الوزن","خالٍ من الجلوتين",List.of(
                new food("غداء",List.of(
                        "سلطة الكينوا",
                        "لفائف الخس",
                        "الأرز البني أو أرز القرنبيط",
                        "الشوربة النباتية الخالية من الجلوتين",
                        "البطاطا الحلوة المشوية",
                        "المعكرونة الخالية من الجلوتين",
                        "التوفو أو التمبيه المشوي"
                ))
        )));

        tableInfo.add(new Tableinfo("فقدان الوزن","منخفض الكربوهيدرات",List.of(
                new food("غداء",List.of(
                        "الخضروات الورقية والخضروات غير النشوية",
                        "البروتين النباتي",
                        "الأفوكادو.",
                        "المكسرات والبذور",
                        "البيض",
                        "المأكولات البحرية",
                        "الزبادي اليوناني (غير المحلى)",
                        "اللحوم الخالية من الدهون",
                        "الأجبان قليلة الكربوهيدرات",
                        "المعكرونة المصنوعة من الخضروات"
                ))
        )));
        tableInfo.add(new Tableinfo("فقدان الوزن","منخفض الكربوهيدرات",List.of(
                new food("عشاء",List.of(
                        "سلطة الخضروات الورقية",
                        "الخضروات المشوية أو المطهية على البخار",
                        "شوربة الكوسا أو البروكلي",
                        "البيض المقلي أو المسلوق",
                        "المأكولات البحرية",
                        "دجاج أو لحم خالٍ من الدهون",
                        "الأفوكادو المحشو",
                        "الأجبان قليلة الكربوهيدرات"
                ))
        )));

        tableInfo.add(new Tableinfo("فقدان الوزن","خالٍ من الجلوتين",List.of(
                new food("عشاء",List.of(
                        "سلطة الخضروات الورقية",
                        "شوربة الخضروات",
                        "سمك مشوي",
                        "الدجاج المشوي أو المطهو على البخار",
                        "التوفو المشوي",
                        "أرز القرنبيط",
                        "البيض (مقلي أو مسلوق)",
                        "الخضروات المحشية",
                        "لفائف الخس",
                        "البطاطا الحلوة المشوية"
                ))
        )));

        tableInfo.add(new Tableinfo("فقدان الوزن","نباتي",List.of(
                new food("عشاء",List.of(
                        "سلطة الخضروات الورقية",
                        "شوربة العدس.",
                        "الخضروات المشوية",
                        "لفائف الخس",
                        "الكينوا مع الخضروات",
                        "نودلز الكوسا",
                        "البطاطا الحلوة المشوية",
                        "الأرز البني أو أرز القرنبيط",
                        "الفاصولياء أو الحمص المطهو",
                        "الفطر المشوي"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","نباتي",List.of(
                new food("فطور",List.of(
                        "الشوفان مع الحليب النباتي والمكسرات",
                        "السموثي",
                        "خبز القمح الكامل مع الأفوكادو",
                        "التوفو المخفوق مع الخضار",
                        "المكسرات والبذور",
                        "الحبوب الكاملة والفاكهة المجففة",
                        "البانكيك النباتي",
                        "بودينغ الشيا"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","خالٍ من الجلوتين",List.of(
                new food("فطور",List.of(
                        "شوفان خالي من الجلوتين مع المكسرات والفواكه",
                        "أومليت بالخضار والأفوكادو",
                        "بانكيك خالي من الجلوتين",
                        "التوست الخالي من الجلوتين مع زبدة المكسرات",
                        "سموثي غني بالبروتين",
                        "بودينغ الشيا مع حليب جوز الهند",
                        "الكرات الطاقوية الخالية من الجلوتين"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","منخفض الكربوهيدرات",List.of(
                new food("فطور",List.of(
                        "أومليت مع الجبن والخضروات",
                        "أفوكادو مع بيض مسلوق أو مقلي",
                        "التوست المصنوع من دقيق اللوز مع زبدة المكسرات",
                        "الشيا بودينغ مع جوز الهند أو حليب اللوز",
                        "كرات الطاقة منخفضة الكربوهيدرات",
                        "سموثي منخفض الكربوهيدرات",
                        "سلطة أفوكادو مع التونة أو الدجاج",
                        "مخفوق التوفو مع الخضار",
                        "الزبادي اليوناني كامل الدسم مع المكسرات"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","نباتي",List.of(
                new food("غداء",List.of(
                        "لفائف الخضروات",
                        "سلطة الحبوب",
                        "الحساء النباتي",
                        "اللفائف النباتية",
                        "البروتين النباتي",
                        "المعكرونة الكاملة مع الصلصة النباتية",
                        "ساندويتش الحمص"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","خالٍ من الجلوتين",List.of(
                new food("غداء",List.of(
                        "سلطة الكينوا",
                        "لفائف الخس",
                        "الأرز البني أو أرز القرنبيط",
                        "الشوربة النباتية الخالية من الجلوتين",
                        "البطاطا الحلوة المشوية",
                        "المعكرونة الخالية من الجلوتين",
                        "التوفو أو التمبيه المشوي"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","منخفض الكربوهيدرات",List.of(
                new food("غداء",List.of(
                        "الخضروات الورقية والخضروات غير النشوية",
                        "البروتين النباتي",
                        "الأفوكادو.",
                        "المكسرات والبذور",
                        "البيض",
                        "المأكولات البحرية",
                        "الزبادي اليوناني (غير المحلى)",
                        "اللحوم الخالية من الدهون",
                        "الأجبان قليلة الكربوهيدرات",
                        "المعكرونة المصنوعة من الخضروات"
                ))
        )));
        tableInfo.add(new Tableinfo("زيادة الوزن","منخفض الكربوهيدرات",List.of(
                new food("عشاء",List.of(
                        "سلطة الخضروات الورقية",
                        "الخضروات المشوية أو المطهية على البخار",
                        "شوربة الكوسا أو البروكلي",
                        "البيض المقلي أو المسلوق",
                        "المأكولات البحرية",
                        "دجاج أو لحم خالٍ من الدهون",
                        "الأفوكادو المحشو",
                        "الأجبان قليلة الكربوهيدرات"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","خالٍ من الجلوتين",List.of(
                new food("عشاء",List.of(
                        "سلطة الخضروات الورقية",
                        "شوربة الخضروات",
                        "سمك مشوي",
                        "الدجاج المشوي أو المطهو على البخار",
                        "التوفو المشوي",
                        "أرز القرنبيط",
                        "البيض (مقلي أو مسلوق)",
                        "الخضروات المحشية",
                        "لفائف الخس",
                        "البطاطا الحلوة المشوية"
                ))
        )));

        tableInfo.add(new Tableinfo("زيادة الوزن","نباتي",List.of(
                new food("عشاء",List.of(
                        "سلطة الخضروات الورقية",
                        "شوربة العدس.",
                        "الخضروات المشوية",
                        "لفائف الخس",
                        "الكينوا مع الخضروات",
                        "نودلز الكوسا",
                        "البطاطا الحلوة المشوية",
                        "الأرز البني أو أرز القرنبيط",
                        "الفاصولياء أو الحمص المطهو",
                        "الفطر المشوي"
                ))
        )));
    }
}
package com.fit.quizcrafter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.fit.quizcrafter.MainActivity;
import com.fit.quizcrafter.R;

public class CreatequizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createquiz);


        Button btn = findViewById(R.id.addQuestionbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBox = findViewById(R.id.mulcheckBox);
                Boolean mul =  checkBox.isChecked();
                EditText editText = findViewById(R.id.editTextTextPersonName);
                System.out.println(editText.getText());

//                add question function
            }
        });

        findViewById(R.id.Addquizbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("add quiz");

                Intent intent = new Intent();
                intent.setClass(getParent(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
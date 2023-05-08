package com.fit.quizcrafter.activity;

import static com.fit.quizcrafter.data.mockData.getQuizDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fit.quizcrafter.R;

import java.util.List;

public class QuizdetailActivity extends AppCompatActivity {
    private LinearLayout detailcontainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizdetail);


        Intent intent =getIntent();
        String msg=intent.getStringExtra("data");
        System.out.println(msg);
        List<String> data = getQuizDetail(msg);
        detailcontainer = findViewById(R.id.detailcontainer);
        for(String s:data)
        {
            Button btn = new Button(this);
            btn.setText(s);
            detailcontainer.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//
//                    Intent intent = new Intent(getActivity(), QuizdetailActivity.class);
//                    intent.putExtra("data", title);
//                    startActivity(intent);
                }
            });
        }
    }



}
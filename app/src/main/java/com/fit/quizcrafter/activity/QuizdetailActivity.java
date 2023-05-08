package com.fit.quizcrafter.activity;

import static com.fit.quizcrafter.data.mockData.getQuizDetail;
import static com.fit.quizcrafter.data.mockData.recentQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.fit.quizcrafter.R;
import com.fit.quizcrafter.api.ApiQuiz;
import com.fit.quizcrafter.api.VolleyCallback;
import com.fit.quizcrafter.domain.Question;
import com.fit.quizcrafter.domain.Quiz;

import java.util.List;

public class QuizdetailActivity extends AppCompatActivity {
    private LinearLayout detailcontainer;
    private Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizdetail);
        Intent intent =getIntent();
        String msg=intent.getStringExtra("data");
        System.out.println(msg);
        detailcontainer = findViewById(R.id.detailcontainer);
        int i =1;
//                simulate real data
        new ApiQuiz().getQuiz(getApplicationContext(), "1", null, null, new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
                quiz = Quiz.parseQuiz(result);
            }
        });
    }
}






//new Response.Listener<String>() {
//@Override
//public void onResponse(String response) {
//        System.out.println(response);
//        quizs[0] = Quiz.parseQuiz(response);
//        quizs[0].setTitle("title");
//        quizs[0].setDescription("description");
//        Quiz quiz =quizs[0];
//        String title = quiz.getTitle();
//        TextView view = new TextView(getApplicationContext());
//        view.setText(title);
//        detailcontainer.addView(view);
//        String description = quiz.getDescription();
//        view = new TextView(getApplicationContext());
//        view.setText(description);
//        detailcontainer.addView(view);
//
//        for(Question question: quiz.getQuestionList())
//        {
//        Button btn = new Button(getApplicationContext());
//        btn.setText(question.getQuestion() + "question");
//        detailcontainer.addView(btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
////
////                    Intent intent = new Intent(getActivity(), QuizdetailActivity.class);
////                    intent.putExtra("data", title);
////                    startActivity(intent);
//        }
//        });
//        }
//
//
//        }
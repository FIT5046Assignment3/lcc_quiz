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
import com.fit.quizcrafter.domain.Question;
import com.fit.quizcrafter.domain.Quiz;

public class CreatequizActivity extends AppCompatActivity {
    private Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createquiz);


        Button btn = findViewById(R.id.addQuestionbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question question = new Question();
                EditText editText = findViewById(R.id.editTextTextPersonName);
                question.setQuestion(editText.getText().toString());
                CheckBox checkBox = findViewById(R.id.mulcheckBox);
                Boolean mul =  checkBox.isChecked();

                if(mul)
                {
                    question.setMultiple_correct_answers("true");
                }
                else
                {
                    question.setMultiple_correct_answers("false");
                }

//              set option
                editText = findViewById(R.id.OptioneditText1);
                question.getAnswers().setAnswer_a(editText.getText().toString());

                editText = findViewById(R.id.OptioneditText2);
                question.getAnswers().setAnswer_b(editText.getText().toString());

                editText = findViewById(R.id.OptioneditText3);
                question.getAnswers().setAnswer_c(editText.getText().toString());

                editText = findViewById(R.id.OptioneditText4);
                question.getAnswers().setAnswer_d(editText.getText().toString());

                editText = findViewById(R.id.OptioneditText5);
                question.getAnswers().setAnswer_e(editText.getText().toString());
//                is multiple
                if(mul)
                {
                    for(String answer: editText.getText().toString().split(","))
                    {
                        System.out.println(answer);
                        switch (answer)
                        {
                            case "1":
                                question.getCorrect_answers().setAnswer_a_correct("true");
                                break;
                            case "2":
                                question.getCorrect_answers().setAnswer_b_correct("true");
                                break;
                            case "3":
                                question.getCorrect_answers().setAnswer_b_correct("true");
                                break;
                            case "4":
                                question.getCorrect_answers().setAnswer_b_correct("true");
                                break;
                            case "5":
                                question.getCorrect_answers().setAnswer_b_correct("true");
                                break;

                        }
                    }
                }
                else
                {
                    editText = findViewById(R.id.AnswereditText);
                    question.setCorrect_answer(editText.getText().toString());
                }
                if(quiz == null)
                {
                    quiz = new Quiz();
                    quiz.addQuestion(question);;
                }
                else
                {
                    quiz.addQuestion(question);
                }
                System.out.println(question);
//                add question function
            }
        });

        findViewById(R.id.Addquizbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("add quiz");
                EditText text = findViewById(R.id.editTextTextPersonName);
                quiz.setTitle(text.getText().toString());
//              data upload
                System.out.println(quiz);



                Intent intent = new Intent();
                intent.setClass(getParent(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
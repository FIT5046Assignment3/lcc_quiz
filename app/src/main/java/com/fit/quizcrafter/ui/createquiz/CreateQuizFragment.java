package com.fit.quizcrafter.ui.createquiz;

import static com.fit.quizcrafter.api.FirebaseApi.addQuiz;
import static com.fit.quizcrafter.api.FirebaseApi.userId;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fit.quizcrafter.R;
import com.fit.quizcrafter.databinding.FragmentCollectionquizBinding;
import com.fit.quizcrafter.databinding.FragmentCreatequizBinding;
import com.fit.quizcrafter.domain.Question;
import com.fit.quizcrafter.domain.Quiz;
import com.fit.quizcrafter.ui.slideshow.SlideshowViewModel;


public class CreateQuizFragment extends Fragment {

    private FragmentCreatequizBinding binding;
    private Quiz quiz;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = FragmentCreatequizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Button btn = binding.addQuestionbtn;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question question = new Question();
                EditText editText = binding.editTextTextPersonName;
                question.setQuestion(editText.getText().toString());
                CheckBox checkBox = binding.mulcheckBox;
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
                editText = binding.OptioneditText1;
                question.getAnswers().setAnswer_a(editText.getText().toString());

                editText = binding.OptioneditText2;
                question.getAnswers().setAnswer_b(editText.getText().toString());

                editText = binding.OptioneditText3;
                question.getAnswers().setAnswer_c(editText.getText().toString());

                editText = binding.OptioneditText4;
                question.getAnswers().setAnswer_d(editText.getText().toString());

                editText = binding.OptioneditText5;
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
                    editText = binding.AnswereditText;
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
                System.out.println(quiz);
//                add question function

            }
        });

        binding.Addquizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("add quiz");
                EditText text = binding.editTextTextPersonName;
                quiz.setTitle(text.getText().toString());
                System.out.println(quiz);
                addQuiz(quiz,userId);
            }
        });
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
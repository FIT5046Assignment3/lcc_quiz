package com.fit.quizcrafter.ui.createquiz;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fit.quizcrafter.QuizWoker;
import com.fit.quizcrafter.R;
import com.fit.quizcrafter.databinding.FragmentCreateQuizBinding;
import com.fit.quizcrafter.domain.Question;

import com.fit.quizcrafter.domain.Quiz;
import com.fit.quizcrafter.domain.User;
import com.fit.quizcrafter.ui.createquiz.recyclelist.QuestionListFragment;
import com.fit.quizcrafter.ui.createquiz.recyclelist.QuestionViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


public class CreateQuizFragment extends Fragment  {

    private FragmentCreateQuizBinding binding;
    private QuestionViewModel viewModel;

    private FirebaseUser fireBaseUser;

    private FirebaseAuth firebaseAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreateQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        binding.addQuestionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddQuestionDialogFragment fragment = new AddQuestionDialogFragment();
                fragment.setAddQuestionListener(new AddQuestionDialogFragment.AddQuestionListener() {
                    @Override
                    public void onAddInputComplete(Question question) {
                        addQuestion(question);
                    }
                });
                fragment.show(getActivity().getSupportFragmentManager(),"addQuestionbtn");
            }
        });

        binding.Addquizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Quiz quiz = new Quiz();
                EditText text = binding.quizTitle;
                quiz.setTitle(text.getText().toString());

                quiz.setDescription(binding.quizDescription.getText().toString());
                quiz.setQuestionList(viewModel.getQuizs().getValue());
                quiz.setKey(UUID.randomUUID().toString());

                QuizWoker.quizList.add(quiz);




//                firebaseAuth = FirebaseAuth.getInstance();
//
//                fireBaseUser = firebaseAuth.getCurrentUser();
//
//                String UserID = fireBaseUser.getUid();
//
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference questionsRef = database.getReference("create-quiz");
//                DatabaseReference newQuestionRef = questionsRef.child(UserID).push();
//
//                newQuestionRef.setValue(quiz);

            }
        });
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void addQuestion(Question question) {
        QuestionListFragment questionListFragment = (QuestionListFragment)binding.recycleQuestionList.getFragment();
        questionListFragment.addQuestion(question);
    }
}
package com.fit.quizcrafter.ui.quizcollection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fit.quizcrafter.databinding.FragmentQuizdetailBinding;
import com.fit.quizcrafter.domain.Quiz;
import com.fit.quizcrafter.ui.slideshow.SlideshowViewModel;
import com.google.gson.Gson;


public class QuizDetail extends Fragment {

    private FragmentQuizdetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentQuizdetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String strquiz= QuizDetailArgs.fromBundle(getArguments()).getQuiz();

        Quiz quiz = new Gson().fromJson(strquiz,Quiz.class);
        System.out.println(strquiz);



        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
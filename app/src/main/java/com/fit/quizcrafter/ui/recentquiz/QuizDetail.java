package com.fit.quizcrafter.ui.recentquiz;

import static com.fit.quizcrafter.data.mockData.recentQuiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.fit.quizcrafter.R;
import com.fit.quizcrafter.databinding.FragmentQuizdetailBinding;
import com.fit.quizcrafter.databinding.FragmentRecentquizBinding;
import com.fit.quizcrafter.ui.slideshow.SlideshowViewModel;
import com.fit.quizcrafter.ui.test.testFragment;


public class QuizDetail extends Fragment {

    private FragmentQuizdetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentQuizdetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
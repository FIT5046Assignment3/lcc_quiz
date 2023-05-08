package com.fit.quizcrafter.ui.recentquiz;

import static com.fit.quizcrafter.data.mockData.recentQuiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.fit.quizcrafter.R;
import com.fit.quizcrafter.activity.QuizdetailActivity;
import com.fit.quizcrafter.databinding.FragmentRecentquizBinding;
import com.fit.quizcrafter.databinding.FragmentSlideshowBinding;
import com.fit.quizcrafter.ui.slideshow.SlideshowViewModel;
import com.fit.quizcrafter.ui.test.testFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecentQuiz extends Fragment {

    private FragmentRecentquizBinding binding;
    private LinearLayout mContainer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentRecentquizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mContainer = binding.container;
        addView();
//        binding.viewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("click");
//                replaceFragment(new QuizDetail());
//            }
//        });
        return root;
    }

    public void addView() {
        System.out.println(recentQuiz.size());
        for(String title:recentQuiz)
        {
            System.out.println(title);
            Button btn = new Button(getContext());
            btn.setText(title);
            mContainer.addView(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("gggggggggggggggggggggggggggggggggg");

                    Intent intent = new Intent(getActivity(), QuizdetailActivity.class);
                    intent.putExtra("data", title);
                    startActivity(intent);
                }
            });
        }
        System.out.println("end");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void replaceFragment(Fragment nextFragment) {
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container_view, nextFragment);
//        fragmentTransaction.commit();
    }
}
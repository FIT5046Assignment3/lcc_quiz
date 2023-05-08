package com.fit.quizcrafter.ui.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fit.quizcrafter.databinding.FragmentSlideshowBinding;
import com.fit.quizcrafter.databinding.TestfragmentBinding;
import com.fit.quizcrafter.ui.slideshow.SlideshowViewModel;

public class testFragment extends Fragment {

    private TestfragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = TestfragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPreferences sharedPref= requireActivity().
                getSharedPreferences("title", Context.MODE_PRIVATE);
        String message= sharedPref.getString("title",null);
        binding.quizid.setText("Message from recent fragment: "+ message);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
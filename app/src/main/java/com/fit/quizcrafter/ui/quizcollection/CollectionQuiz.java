package com.fit.quizcrafter.ui.quizcollection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.fit.quizcrafter.R;
import com.fit.quizcrafter.databinding.FragmentCollectionquizBinding;
import com.fit.quizcrafter.ui.slideshow.SlideshowViewModel;

public class CollectionQuiz extends Fragment {

    private FragmentCollectionquizBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = FragmentCollectionquizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
package com.fit.quizcrafter.ui.quizcollection;

import static com.fit.quizcrafter.api.FirebaseApi.getQuizByuserId;
import static com.fit.quizcrafter.api.FirebaseApi.userId;
import static com.fit.quizcrafter.data.mockData.recentQuiz;
import static com.fit.quizcrafter.ui.UtilFragment.replaceFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fit.quizcrafter.R;

import com.fit.quizcrafter.domain.Quiz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizItemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuizItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizItemFragment newInstance(String param1, String param2) {
        QuizItemFragment fragment = new QuizItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_quizitem, container, false);
//        load data from firebase
        getQuizByuserId(userId, new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                LinearLayout linearLayout = view.findViewById(R.id.quizlist);
                System.out.println("/////////////////////////////////");
                for(DataSnapshot dataSnapshot: task.getResult().getChildren())
                {
                    Quiz quiz =  dataSnapshot.getValue(Quiz.class);
                    Button btn = new Button(getContext());
                    btn.setText(quiz.getTitle());
                    linearLayout.addView(btn);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            tranform key and quiz detail

                            QuizItemFragmentDirections.ActionQuizItemFragmentToQuizDetail action =
                                    QuizItemFragmentDirections.actionQuizItemFragmentToQuizDetail(new Gson().toJson(quiz));
                            Navigation.findNavController(view).navigate(action);

                        }
                    });
                }




            }
        });


        return view;
    }

}
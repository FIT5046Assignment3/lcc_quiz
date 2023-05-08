package com.fit.quizcrafter.data;

import java.util.ArrayList;
import java.util.List;

public class mockData {

    public static List<String>  recentQuiz = new ArrayList<>();
    static{
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
        recentQuiz.add("Java");
    }

    public static List<String> getQuizDetail(String title)
    {
        String description = "it is very easy";
        List<String> data = new ArrayList<>();
        data.add(description);
        data.add("question 1");
        data.add("question 2");
        data.add("question 3");
        data.add("question 4");
        data.add("question 5");

        return data;
    }
}

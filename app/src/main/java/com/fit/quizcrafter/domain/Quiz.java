package com.fit.quizcrafter.domain;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {
    private List<Question> questionList;
    private String title;
    private String description = " quiz desciption";

    public Quiz() {
        title = "titile" + String.valueOf(new Random().nextInt());
        questionList = new ArrayList<>();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getTitle() {
        return title;
    }

    public boolean addQuestion(Question question)
    {
        return questionList.add(question);
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Quiz parseQuiz(String str)
    {
        List<Question> list =  new Gson().fromJson(str, new TypeToken<List<Question>>(){}.getType());
        Quiz quiz = new Quiz();
        quiz.setQuestionList(list);
        return quiz;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "questionList=" + questionList +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.example.android.quiz_application;

import com.example.android.quiz_application.MainActivity;

/**
 * Created by Android on 18-Jun-16.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean truequestion) {
        mQuestion = question;
        mTrueQuestion = truequestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question)
    {
        mQuestion = question;
    }

    public boolean isTrueQuestion()
    {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion)
    {
        mTrueQuestion = trueQuestion;
    }
}

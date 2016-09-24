package com.example.android.quiz_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextview;
    private Button mShowAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);


        // page 103 there is error on this line !
       // mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);


        mAnswerTextview = (TextView)findViewById(R.id.answer_textview);
        mShowAnswer = (Button)findViewById(R.id.btn_show_answer);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue)
                {
                    mAnswerTextview.setText(R.string.text_true);
                }
                else
                {
                    mAnswerTextview.setText(R.string.text_false);
                }
            }
        });


    }
}

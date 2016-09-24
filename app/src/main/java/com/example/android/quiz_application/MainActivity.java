package com.example.android.quiz_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button mtruebutton;
    private Button mfalsebutton;
    private Button mNextbutton;
    private Button mPreviousbutton;
    private Button mcheatbutton;
    private TextView mQuestionTextview;
    TrueFalse a;
    private static final String TAG = "MainActivity" ;
    private static final String KEY_INDEX = "index";
    public static String EXTRA_ANSWER_IS_TRUE = "com.example.android.quiz_application.answer_is_true";
    //public static int d(String tag, String msg)
    private TrueFalse[] mQuestionBank = new TrueFalse[]
            {
                    new TrueFalse(R.string.question_africa , false),
                    new TrueFalse(R.string.question_america, true),
                    new TrueFalse(R.string.question_asia, true),
                    new TrueFalse(R.string.question_mideast ,false),
                    new TrueFalse(R.string.question_ocean, true)
            };

    private int mCurrentIndex = 0;
    private void updateQuestion()
    {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextview.setText(question);
    }

    private void checkAnswer(Boolean userPressedTrue)
    {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue)
        {
            messageResId = R.string.toast_true;
        }
        else
        {
            messageResId = R.string.toast_flase;
        }
        Toast.makeText(this, messageResId , Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called ");
        setContentView(R.layout.activity_main);

        mQuestionTextview = (TextView) findViewById(R.id.question_textview);
        //   int question = mQuestionBank[mCurrentIndex].getQuestion();
        //   mQuestionTextview.setText(question);
        mQuestionTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mtruebutton = (Button) findViewById(R.id.btn_true);
        mfalsebutton = (Button) findViewById(R.id.btn_false);

        mtruebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,R.string.toast_true, Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });

        mfalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(MainActivity.this,R.string.toast_flase,Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        mNextbutton = (Button) findViewById(R.id.btn_next);
        mNextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                //    int question = mQuestionBank[mCurrentIndex].getQuestion();
                //    mQuestionTextview.setText(question);
                updateQuestion();
            }
        });


        mPreviousbutton = (Button) findViewById(R.id.btn_previous);
        mPreviousbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        updateQuestion();

        mcheatbutton = (Button)findViewById(R.id.btn_cheat);
        mcheatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion() ;
                intent.putExtra(EXTRA_ANSWER_IS_TRUE , answerIsTrue);
                startActivity(intent);
            }
        });

    }   // on create() ends here



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

}

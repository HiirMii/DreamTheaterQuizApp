package com.example.android.dreamtheaterquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quizScore = 0;
    LinearLayout result;
    LinearLayout quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting visibility of result layout to gone

        result = (LinearLayout) findViewById(R.id.result);
        result.setVisibility(View.GONE);

        final Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting visibility
                quiz = (LinearLayout) findViewById(R.id.quiz);
                quiz.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                result.setVisibility(View.VISIBLE);

                //updating info in result layout
                setResult();
                displayResultScore();
                displayResultText();
            }
        });
    }

    public void setResult () {

        boolean correctAnswer;

        //question1

        //checking if correct answer has been checked
        RadioButton questionOneAnswer = (RadioButton) findViewById(R.id.q1answer);
        correctAnswer = questionOneAnswer.isChecked();

        if(correctAnswer) {
            quizScore += 1;
        }

        //question2

        CheckBox questionTwoCheckboxOne = (CheckBox) findViewById(R.id.q2answer1);
        CheckBox questionTwoCheckboxTwo = (CheckBox) findViewById(R.id.q2answer2);
        CheckBox questionTwoCheckboxThree = (CheckBox) findViewById(R.id.q2answer3);
        CheckBox questionTwoCheckboxFour = (CheckBox) findViewById(R.id.q2answer4);

        //boolean array stores values of checked/unchecked states if all true then answered correctly
        boolean [] questionTwoCheckboxAnswers = {questionTwoCheckboxOne.isChecked(), !questionTwoCheckboxTwo.isChecked(), !questionTwoCheckboxThree.isChecked(), questionTwoCheckboxFour.isChecked()};
        for (boolean answer : questionTwoCheckboxAnswers ) {
            correctAnswer = answer;
        }

        if(correctAnswer) {
            quizScore += 1;
        }

        //question3

        EditText questionThreeAnswer = (EditText) findViewById(R.id.q3answer);
        String questionThreeString = questionThreeAnswer.getText().toString();

        //checking if provided answer matches the correct string
        if(questionThreeString.toLowerCase().contains("octavarium")) {
            quizScore += 1;
        }

        //question4

        //checking if correct answer has been checked
        RadioButton questionFourAnswer = (RadioButton) findViewById(R.id.q4answer);
        correctAnswer = questionFourAnswer.isChecked();

        if(correctAnswer) {
            quizScore += 1;
        }

        //question5

        CheckBox questionFiveCheckboxOne = (CheckBox) findViewById(R.id.q5answer1);
        CheckBox questionFiveCheckboxTwo = (CheckBox) findViewById(R.id.q5answer2);
        CheckBox questionFiveCheckboxThree = (CheckBox) findViewById(R.id.q5answer3);
        CheckBox questionFiveCheckboxFour = (CheckBox) findViewById(R.id.q5answer4);

        //boolean array stores values of checked/unchecked states if all true then answered correctly
        boolean [] questionFiveCheckboxAnswers = {questionFiveCheckboxOne.isChecked(), questionFiveCheckboxTwo.isChecked(), !questionFiveCheckboxThree.isChecked(), questionFiveCheckboxFour.isChecked()};
        for (boolean answer : questionFiveCheckboxAnswers ) {
            correctAnswer = answer;
        }

        if(correctAnswer) {
            quizScore += 1;
        }

        //question6

        EditText questionSixAnswer = (EditText) findViewById(R.id.q6answer);
        String questionSixString = questionSixAnswer.getText().toString();

        //checking if provided answer matches the correct string
        if(questionSixString.toLowerCase().contains("bass")) {
            quizScore += 1;
        }
    }


    /**
     * Displays amount of correct answers.
     */

    public void displayResultScore () {
        EditText nameView = (EditText) findViewById(R.id.name);
        String name = nameView.getText().toString();
        String score = "" + quizScore;
        String finalScore = getString(R.string.score, name, score);
        TextView resultScoreView = (TextView) findViewById(R.id.result_score);
        resultScoreView.setText(finalScore);
    }

    /**
     * Displays quiz grading button info based on the score.
     */

    public void displayResultText () {
        String resultText;
        TextView resultTextView = (TextView) findViewById(R.id.result_text);
        if (quizScore <= 2) {
            resultText = getString(R.string.low_score);
            resultTextView.setText(resultText);
        }else if (quizScore > 2 && quizScore <= 4) {
            resultText = getString(R.string.medium_score);
            resultTextView.setText(resultText);
        } else {
            resultText = getString(R.string.high_score);
            resultTextView.setText(resultText);
        }
    }
}

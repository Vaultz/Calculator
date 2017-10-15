package com.example.vault_.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // NEEDED VARIABLES FOR CALCULATION
    static String operand;
    static String leftValue;
    static String rightValue;
    static boolean cleanResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand = "";
        leftValue = "";
        rightValue = "";


        cleanResult = false;
        // FIGURES
        final Button[] figureButtons = new Button[10];

        final Button button0 = (Button)findViewById(R.id.button0);
        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button3 = (Button)findViewById(R.id.button3);
        final Button button4 = (Button)findViewById(R.id.button4);
        final Button button5 = (Button)findViewById(R.id.button5);
        final Button button6 = (Button)findViewById(R.id.button6);
        final Button button7 = (Button)findViewById(R.id.button7);
        final Button button8 = (Button)findViewById(R.id.button8);
        final Button button9 = (Button)findViewById(R.id.button9);

        figureButtons[0] = button0;
        figureButtons[1] = button1;
        figureButtons[2] = button2;
        figureButtons[3] = button3;
        figureButtons[4] = button4;
        figureButtons[5] = button5;
        figureButtons[6] = button6;
        figureButtons[7] = button7;
        figureButtons[8] = button8;
        figureButtons[9] = button9;

        // OPERANDS
        final Button[] operandButtons = new Button[4];
        final Button buttonPlus = (Button)findViewById(R.id.buttonPlus);
        final Button buttonMinus = (Button)findViewById(R.id.buttonMinus);
        final Button buttonTimes = (Button)findViewById(R.id.buttonTimes);
        final Button buttonDivide = (Button)findViewById(R.id.buttonDivide);

        operandButtons[0] = buttonPlus;
        operandButtons[1] = buttonMinus;
        operandButtons[2] = buttonTimes;
        operandButtons[3] = buttonDivide;

        // FUNCTIONS
        final Button[] functionButtons = new Button[3];
        final Button buttonPoint = (Button)findViewById(R.id.buttonPoint);
        final Button buttonEquals = (Button)findViewById(R.id.buttonEquals);
        final Button buttonClear = (Button)findViewById(R.id.buttonC);

        functionButtons[0] = buttonPoint;
        functionButtons[1] = buttonEquals;
        functionButtons[2] = buttonClear;



        // FIGUREBUTTONS ACTIONS
        int i = 0;
        while (i < 10) {
            final int j = i;
            figureButtons[j].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    String buttonValue = String.valueOf(figureButtons[j].getText());

                    // View

                    TextView resultView = (TextView) findViewById(R.id.result);
                    String result = String.valueOf(resultView.getText());

                    if (result.equals("0") || cleanResult) {
                        resultView.setText(buttonValue);
                        if (cleanResult) {
                            cleanResult = false;
                        }
                    }
                    else {
                        resultView.setText(resultView.getText()+buttonValue);
                    }

                }
            });
            i++;
        }


        // OPERAND BUTTONS
        i = 0;
        while (i < 4) {
            final int j = i;
            operandButtons[j].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                cleanResult = false;
                String buttonValue = String.valueOf(operandButtons[j].getText());

                // View
                TextView resultView = (TextView) findViewById(R.id.result);
                String result = String.valueOf(resultView.getText());

                if (Character.isDigit(result.charAt(result.length()-1))) {
                    leftValue = result;
                    resultView.setText(resultView.getText()+buttonValue);
                    operand = buttonValue;
                }

                }
            });
            i++;
        }


        buttonEquals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView resultView = (TextView) findViewById(R.id.result);
                String result = String.valueOf(resultView.getText());

                try
                {
                    Double.parseDouble(result);

                } catch(NumberFormatException e) {

                    boolean rightValueFound = false;
                    for (int i = 0 ; i < result.length() ; i++) {
                        if (!rightValueFound) {
                            if (!(Character.isDigit(result.charAt(i))) && (result.charAt(i) != '.')) {
                                Log.v("FOUND CHAR", ""+result.charAt(i));
                                rightValueFound = true;
                            }
                        }
                        else {
                            rightValue += result.charAt(i);
                        }
                    }

                    double doubleResult = 0;
                    double leftDouble;
                    double rightDouble;

                   // Log.v("Value of result :"+result, " // Value of leftValue : "+leftValue+" // Value of rightValue :"+rightValue);
                    leftDouble = Double.parseDouble(leftValue);
                    rightDouble = Double.parseDouble(rightValue);

                    switch (operand) {
                        case "+":
                            doubleResult = leftDouble+rightDouble;
                            break;

                        case "-":
                            doubleResult = leftDouble-rightDouble;
                            break;

                        case "*":
                            doubleResult = leftDouble*rightDouble;
                            break;

                        case "/":
                            doubleResult = leftDouble/rightDouble;
                            break;

                    }

                    resultView.setText(String.valueOf(doubleResult));
                    leftValue = String.valueOf(doubleResult);
                    rightValue = "";
                    cleanResult = true;

                }

            }
        });



    }

    private double tryParseDouble(String number) {
        if (number != null && number.length() > 0) {
            try {
                return Double.parseDouble(number);
            }
            catch(Exception e) {
                return 0;
            }
        }
        else return 0;
    }


}


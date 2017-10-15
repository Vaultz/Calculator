package com.example.vault_.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static int countingInputs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button[] buttons = new Button[16];

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
        final Button buttonPoint = (Button)findViewById(R.id.buttonPoint);
        final Button buttonPlus = (Button)findViewById(R.id.buttonPlus);
        final Button buttonMinus = (Button)findViewById(R.id.buttonMinus);
        final Button buttonTimes = (Button)findViewById(R.id.buttonTimes);
        final Button buttonDivide = (Button)findViewById(R.id.buttonDivide);
        final Button buttonEquals = (Button)findViewById(R.id.buttonEquals);
        final Button buttonClear = (Button)findViewById(R.id.buttonC);

        final ArrayList<String> numbers = new ArrayList<String>();
        final ArrayList<String> operands = new ArrayList<String>();


        numbers.add("0");

        // NUMBERS
        buttons[0] = button0;
        buttons[1] = button1;
        buttons[2] = button2;
        buttons[3] = button3;
        buttons[4] = button4;
        buttons[5] = button5;
        buttons[6] = button6;
        buttons[7] = button7;
        buttons[8] = button8;
        buttons[9] = button9;

        int i = 0;
        while (i < 9) {
            final int j = i;
            buttons[j].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    String buttonValue = String.valueOf(buttons[j].getText());

                    // Model
                    numbers.set(countingInputs, numbers.get(countingInputs)+buttonValue);

                    // View
                    TextView resultView = (TextView) findViewById(R.id.result);
                    String result = String.valueOf(resultView.getText());

                    if (result == "0") {
                        resultView.setText(buttonValue);
                    }
                    else {
                        resultView.setText(resultView.getText()+buttonValue);
                    }

                }
            });
            i++;
        }

        // OPERANDS
        buttons[10] = buttonPoint;
        buttons[11] = buttonPlus;
        buttons[12] = buttonMinus;
        buttons[13] = buttonTimes;
        buttons[14] = buttonDivide;
        buttons[15] = buttonEquals;
        buttons[16] = buttonClear;

        while (i < 14) {
            final int j = i;
            buttons[j].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    String buttonValue = String.valueOf(buttons[j].getText());

                    // Model
                    operands.add(buttonValue);
                    numbers.add("0");
                    countingInputs++;

                    // View
                    TextView resultView = (TextView) findViewById(R.id.result);
                    String result = String.valueOf(resultView.getText());

                    // getting the input
                    String lastChar = result.substring(result.length() - 1);

                    // last input is a number : register the number + the operand
                    if (isInteger(lastChar)) {
                        numbers.add(result);
                    }
                }
            });
            i++;
        }
    }

        public static boolean isInteger(String s) {
            boolean isValidInteger = false;
            try
            {
                Integer.parseInt(s);

                // s is a valid integer

                isValidInteger = true;
            }
            catch (NumberFormatException ex)
            {
                // s is not an integer
            }

            return isValidInteger;
        }
    }


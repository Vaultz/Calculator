package com.example.vault_.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        buttons[10] = buttonPoint;
        buttons[11] = buttonPlus;
        buttons[12] = buttonMinus;
        buttons[13] = buttonTimes;
        buttons[14] = buttonDivide;
        buttons[15] = buttonEquals;

        for (int i = 0 ; i < buttons.length-1 ; i++) {
            final int j = i;
            buttons[j].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    TextView resultView = (TextView) findViewById(R.id.result);

                    String resultNumber = String.valueOf(resultView.getText());

                    if (resultNumber == "0") {
                        resultView.setText(String.valueOf(buttons[j].getText()));
                    }
                    else {
                        resultView.setText(resultView.getText()+String.valueOf(buttons[j].getText()));
                    }

                }
            });
        }

        final Button buttonC = (Button)findViewById(R.id.buttonC);




    }
}

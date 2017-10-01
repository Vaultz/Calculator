package com.example.vault_.calculatrice;

import android.widget.Button;

/**
 * Created by Vault_ on 01/10/2017.
 */

public class ButtonObject {
    private Button button;
    private char value;

    public ButtonObject(Button button, char value) {
        this.button = button;
        this.value = value;
    }

    public Button getButton() {
        return this.button;
    }
    public char getValue() {
        return this.value;
    }
}

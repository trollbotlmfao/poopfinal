package org.example;

import java.awt.*;

public class Cell extends Rectangle {
    private boolean clicked;
    private int value;

    public Cell(boolean clicked, int value) {
        this.clicked = clicked;
        this.value = value;
    }
    public boolean isClicked() {
        return clicked;

    }
    public int getValue() {
        return value;
    }

    public void setClicked(boolean click) {
        this.clicked = click;
    }
    public void setValue(int val) {
        this.value = val;
    }

}

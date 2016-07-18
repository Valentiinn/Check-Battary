package com.karayvansky.battary;

import javax.swing.*;

public class BasicLayouts {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainForm();
            }
        });
    }
}

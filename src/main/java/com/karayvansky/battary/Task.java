package com.karayvansky.battary;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;


public class Task extends TimerTask {
    Battery batteryChargeLevelfirst;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Task instance = null;

    private Task(Battery batteryChargeLevelfirst) {
        this.batteryChargeLevelfirst = batteryChargeLevelfirst;
    }

    public static Task getInstance(Battery batteryChargeLevelfirst) {
        if (instance == null)
            instance = new Task(batteryChargeLevelfirst);
        return instance;
    }

    @Override
    public void run() {
        messageDialog();
    }

    public void messageDialog() {

        double valueBattery = batteryChargeLevelfirst.valueBattery();

        if (valueBattery > 81 & batteryChargeLevelfirst.power()) {
            toolkit.beep();
            JOptionPane.showMessageDialog(null, "Отсоедините ноутбук от зарядки! Уже " + valueBattery + " %",
                    "Battary warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        while (batteryChargeLevelfirst.valueBattery() <= 37 & !batteryChargeLevelfirst.power()) {
            toolkit.beep();
            JOptionPane.showMessageDialog(null, "Подключите ноутбук на зарядку! Осталось " + valueBattery + " %",
                    "Battary warning", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}

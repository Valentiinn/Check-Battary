package com.karayvansky.battary;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class Task extends TimerTask {
    private BatteryChargeLevel batteryChargeLevelfirst = new BatteryChargeLevel();
    private Timer timer = new Timer();
    private Toolkit toolkit = Toolkit.getDefaultToolkit();

    @Override
    public void run() {
        messageDialog();
    }

    public void messageDialog() {

        double firstvalueBattery = batteryChargeLevelfirst.valueBattery();

        while (firstvalueBattery <= 37 & !batteryChargeLevelfirst.power()) {
            toolkit.beep();
            JOptionPane.showMessageDialog(null, "Поставь ноутбук на зарядку! Осталось " + firstvalueBattery + " %",
                    "Battary warning", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}

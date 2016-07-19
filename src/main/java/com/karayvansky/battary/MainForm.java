package com.karayvansky.battary;

import javax.swing.*;
import java.util.Timer;

public class MainForm extends JFrame {
    private Timer timer = new Timer();
    private Battery batteryChargeLevel = BatteryChargeLevel.getInstance();
    private Task task = Task.getInstance(batteryChargeLevel);

    public MainForm() {
        super("Basic Layouts");
        timer.schedule(task, 5000, 180000);
    }
}

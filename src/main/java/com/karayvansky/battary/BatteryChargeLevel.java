package com.karayvansky.battary;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;

public class BatteryChargeLevel {

    public double valueBattery() {
        double value = 0;
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        for (PowerSource pSource : hal.getPowerSources()) {
            value = pSource.getRemainingCapacity() * 100d;
            hal.getPowerSources();
        }
        return Math.rint(10.0 * value) / 10.0;
    }

    public boolean power() {
        double value = 0;
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        for (PowerSource pSource : hal.getPowerSources()) {
            value = pSource.getTimeRemaining();
            hal.getPowerSources();
            if (value == -2)
                return true;
        }
        return false;
    }

}

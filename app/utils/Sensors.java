package utils;

import models.MeasurementType;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */
public class Sensors {

    public static Map<MeasurementType, String[]> getSensors() {

        Map<MeasurementType, String[]> cmds = new HashMap<>();

        // modify this.
        String[] cmd1 = {
                "/bin/sh",
                "-c",
                "sensors | grep 'Core 0' | cut -d'+' -f2 | cut -d'C' -f1"
        };
        String[] cmd2 = {
                "/bin/sh",
                "-c",
                "sensors | grep temp1 | cut -d'+' -f2 | cut -d' ' -f1"
        };
        String[] cmd3 = {
                "/bin/sh",
                "-c",
                "sensors | grep 'Core 1' | cut -d'+' -f2 | cut -d'C' -f1"
        };

        cmds.put(MeasurementType.CORE, cmd1);
        cmds.put(MeasurementType.EXTERNAL, cmd2);
        cmds.put(MeasurementType.MOBO, cmd3);

        return cmds;
    }
}

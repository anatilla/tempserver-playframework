package measurator;

import models.Measurement;
import models.MeasurementType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */
class Measurator {

    private Map<MeasurementType, String[]> cmds;
    private Measurement meas;

    public Measurator(Map<MeasurementType, String[]> cmds) {
        this.cmds = cmds;

    }

    public Measurement getMeasurement() {
        if (meas == null) {
            this.run();
        }

        return meas;
    }

    public void run() {
        meas = new Measurement();
        meas.setUnix_time(System.currentTimeMillis());

        cmds.forEach((type, cmd) -> {

            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    float f = Float.parseFloat(line);

                    if (type.equals(MeasurementType.CORE)) meas.setCore((f));
                    if (type.equals(MeasurementType.MOBO)) meas.setMobo((f));
                    if (type.equals(MeasurementType.EXTERNAL)) meas.setExternal(f);
                }

            } catch (NullPointerException e) {

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

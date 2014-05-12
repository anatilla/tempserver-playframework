package measurator;

import models.Measurement;
import models.MeasurementType;
import play.db.jpa.JPA;
import play.libs.F;
import utils.Sensors;

import java.util.Map;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */
public class MeasureService {

    public static Measurement getMeasurement(Map<MeasurementType, String[]> cmds) {
        Measurator meas = new Measurator(cmds);
        return meas.getMeasurement();
    }

    public static void persistMeasurement() {


        JPA.withTransaction(new F.Callback0() {
            public void invoke() throws Throwable {
		final Map<MeasurementType, String[]> sensors = Sensors.getSensors();
		final Measurement measurement = MeasureService.getMeasurement(sensors);
                measurement.save();
            }
        });

    }


}

package actors;

import akka.actor.UntypedActor;
import measurator.MeasureService;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */
public class CollectorActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        String msg = (String) message;
        if (msg.equalsIgnoreCase("collect")) MeasureService.persistMeasurement();
        else unhandled(message);
    }
}

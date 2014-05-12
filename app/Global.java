import actors.CollectorActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.Application;
import play.GlobalSettings;
import play.db.jpa.Transactional;
import play.libs.Akka;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */
public class Global extends GlobalSettings {

    @Override
    @Transactional
    public void onStart(Application app) {

        ActorRef actorRef = Akka.system().actorOf(new Props(CollectorActor.class));

        Akka.system().scheduler().schedule(
                Duration.create(0, TimeUnit.MILLISECONDS),
                Duration.create(5, TimeUnit.MINUTES),
                actorRef,
                "collect",
                Akka.system().dispatcher(),
                null
        );

    }


}

tempserver-playframework
========================

Temperature logger and plotter implemented with Play! framework and Akka

# dependencies


+ Play! Framework (2.2.x)
+ sbt
+ Java
+ Scala
+ PostgreSQL
+ lm-sensors


# install/setup
First, edit <a href="https://github.com/anatilla/tempserver-playframework/blob/master/app/utils/Sensors.java"> app.utils.Sensors</a> class to fit with your sensors configuration (require bash skills).


Refer to <a href="http://www.playframework.com/documentation/2.0/Production">Play documentation</a> for deploy/run.
Default port is 9000 (default Play! settings)

For a rapid test of the application, get in tempserver-playframework's directory, then type:

    $ play ~run

Then browse <a href="http://localhost:9000/log">http://localhost:9000/log</a> for real time plot.

For history plot browse <a href="http://localhost:9000/plot">http://localhost:9000/plot</a>





name := "tempserver-playframework"

version := "1.0-SNAPSHOT"


libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
  "postgresql" % "postgresql" % "8.4-701.jdbc4"
)


play.Project.playJavaSettings

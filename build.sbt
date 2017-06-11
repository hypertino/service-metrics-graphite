name := "service-metrics-graphite"

version := "0.3-SNAPSHOT"

organization := "com.hypertino"

scalaVersion := "2.12.1"

crossScalaVersions := Seq("2.12.1", "2.11.8")

libraryDependencies ++= Seq(
  "io.dropwizard.metrics" % "metrics-graphite" % "3.2.2",
  "com.hypertino" %% "service-metrics" % "0.3-SNAPSHOT",
  "com.hypertino" %% "typesafe-config-binders" % "0.13-SNAPSHOT",
  "org.slf4j" % "slf4j-api" % "1.7.21"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("public")
)

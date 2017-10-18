name := "service-metrics-graphite"

version := "0.3.0"

organization := "com.hypertino"

crossScalaVersions := Seq("2.12.3", "2.11.11")

scalaVersion := crossScalaVersions.value.head

libraryDependencies ++= Seq(
  "io.dropwizard.metrics" % "metrics-graphite" % "3.2.5",
  "com.hypertino" %% "service-metrics" % "0.3.0",
  "com.hypertino" %% "typesafe-config-binders" % "0.2.0",
  "org.slf4j" % "slf4j-api" % "1.7.25"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("public")
)

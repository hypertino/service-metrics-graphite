import sbt.Keys._

name := "service-metrics-graphite"

version := "0.2"

organization := "eu.inn"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8")

resolvers ++= Seq(
  Resolver.sonatypeRepo("public")
)

libraryDependencies ++= Seq(
  "io.dropwizard.metrics" % "metrics-graphite" % "3.1.0",
  "eu.inn" %% "service-metrics" % "0.2.9",
  "eu.inn" %% "binders-typesafe-config" % "0.12.13"
)

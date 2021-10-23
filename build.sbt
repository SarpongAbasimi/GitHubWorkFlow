import Dependencies.Libraries

ThisBuild / organization := "org.learn"
ThisBuild/ version := "trial-version"
version := "0.1"

name := "publish"

scalaVersion := "2.13.6"

lazy val core = (project in file("./modules/core"))
.settings(
  Test / fork := true,
  testFrameworks += new TestFramework("weaver.framework.CatsEffect"),
  libraryDependencies ++= Seq(
    Libraries.catsEffect,
    Libraries.weaverTest,
    Libraries.circeCore,
    Libraries.circeGeneric,
    Libraries.circeParser,
    Libraries.circeGenericExtra
  )
)


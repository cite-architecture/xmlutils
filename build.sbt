name := "XML text utilities"


// Scala XML API changed from 2.10 to 2.11
crossScalaVersions in ThisBuild := Seq("2.11.8", "2.12.4")
scalaVersion := (crossScalaVersions in ThisBuild).value.last

name := "xmlutils"
organization := "edu.holycross.shot"
version := "1.0.0"
licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html"))
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
)

tutTargetDirectory := file("docs")
tutSourceDirectory := file("src/main/tut")
enablePlugins(TutPlugin)

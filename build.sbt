ThisBuild / crossScalaVersions  := List("2.11.8", "2.12.4")


name := "xmlutils"
organization := "edu.holycross.shot"
version := "2.0.1"
licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html"))
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
)

resolvers += "Nexus" at "https://terracotta.hpcc.uh.edu/nexus/repository/maven-releases/"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

publishTo := Some("releases" at "https://terracotta.hpcc.uh.edu/nexus/repository/maven-releases/")


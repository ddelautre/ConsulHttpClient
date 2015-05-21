name := "ConsulHttpClient"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.ning" % "async-http-client" % "1.9.24",
  "org.scalatest" %% "scalatest" % "2.2.4" % Test,
  "spray-gun" % "spray-gun_2.11" % "1.2.0" % Test
)
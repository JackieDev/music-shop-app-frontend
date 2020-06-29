name := "music-shop-app-frontend"

version := "0.1"

scalaVersion := "2.13.1"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

val http4s = "0.21.3"
val circe = "0.13.0"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server"  % http4s,
  "org.http4s" %% "http4s-blaze-client"  % http4s,
  "org.http4s" %% "http4s-dsl"           % http4s,
  "org.http4s" %% "http4s-twirl"         % "0.21.0-M4",
  "org.http4s" %% "http4s-circe"         % http4s,
  "io.circe"   %% "circe-core"           % circe,
  "io.circe"   %% "circe-generic"        % circe,
  //"io.circe"   %% "circe-refined"        % circe,
  "io.circe"   %% "circe-parser"         % circe,
)

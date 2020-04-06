scalaVersion := "2.13.1"
organization := "com.example"

val itext7Core  = "com.itextpdf"         % "itext7-core"  % "7.1.10" pomOnly ()
val html2pdf    = "com.itextpdf"         % "html2pdf"     % "2.1.7"

lazy val `itext-bug` = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "Itext-Bug",
    libraryDependencies ++= Seq(itext7Core, html2pdf)
  )

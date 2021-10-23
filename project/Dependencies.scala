import sbt._

object Dependencies {

  val catsEffectsVersion =  "3.2.9"
  val weaverTestVersion = "0.7.6"
  val circeVersion = "0.13.0"



  def circeLibrary(artifactId: String): ModuleID = "io.circe" %% artifactId % circeVersion

  object Libraries {
    val catsEffect = "org.typelevel" %% "cats-effect" % catsEffectsVersion

    val circeCore = circeLibrary("circe-core")
    val circeGeneric = circeLibrary("circe-generic")
    val circeParser = circeLibrary("circe-parser")
    val circeGenericExtra = circeLibrary("circe-generic-extras")


    // Testing
    val weaverTest = "com.disneystreaming" %% "weaver-cats" % weaverTestVersion % Test
  }
}

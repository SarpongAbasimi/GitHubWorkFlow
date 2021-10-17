import sbt._

object Dependencies {

  val catsEffectsVersion =  "3.2.9"
  val weaverTestVersion = "0.7.6"


  object Libraries {
    val catsEffect = "org.typelevel" %% "cats-effect" % catsEffectsVersion


    // Testing
    val weaverTest = "com.disneystreaming" %% "weaver-cats" % weaverTestVersion % Test
  }
}

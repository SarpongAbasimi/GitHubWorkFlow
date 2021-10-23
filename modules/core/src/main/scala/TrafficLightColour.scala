import io.circe.generic.extras.semiauto._
import io.circe.{ Decoder, Encoder }
import io.circe.syntax._
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._



object Main {

  implicit val customConfig: Configuration = Configuration.default.withDefaults.withDiscriminator("type")

  sealed trait Stuff
  case class Foo(thisIsAString: String, anotherField: Int = 13) extends Stuff
  case class Bar(thisIsAString: String, anotherField: Int = 13) extends Stuff

  object Foo {
    implicit val decodeBar: Decoder[Bar] = deriveConfiguredDecoder
    implicit val encodeBar: Encoder[Bar] = deriveConfiguredEncoder
  }

  object Bar {
    implicit val decodeBar: Decoder[Bar] = deriveConfiguredDecoder
    implicit val encodeBar: Encoder[Bar] = deriveConfiguredEncoder
  }

  def main(args: Array[String]): Unit = {
    val foo: Stuff = Foo("abc", 123)
    val bar: Stuff = Bar("xyz", 987)

    val fooString = foo.asJson.noSpaces
    println(fooString)
  }

  def jsonConverterPrinter[SomeType : Encoder](trafficColour: SomeType): Unit = {
    println(trafficColour.asJson.spaces4)
  }

  lazy val aRandomString = """{
                             |"name":"red"
                             |}""".stripMargin

}




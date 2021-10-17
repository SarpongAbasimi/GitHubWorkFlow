import cats.effect.IO
import weaver.SimpleIOSuite

object GreeterSpec extends SimpleIOSuite {

  test("Test that talk returns a name"){
    for {
      name <- greeterAlg.talk("Ben")
    } yield expect(name == "Ben")
  }

  private [this] lazy val greeterAlg = new GreeterAlgebra[IO] {
    def greet(name: String): IO[Unit] = IO.unit
    def talk(name: String): IO[String] = IO(name)
  }
}

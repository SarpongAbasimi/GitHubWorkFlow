import cats.effect.kernel.{Clock, Sync}
import cats.effect.std.Console

trait GreeterAlgebra[F[_]] {
  def greet(name: String): F[Unit]
  def talk(name: String): F[String]
}

object GreeterAlgebra {
  def GreeterAlgebraImp[F[_]: Clock: Console: Sync]: GreeterAlgebra[F] =  new GreeterAlgebra[F] {
    def greet(name: String): F[Unit] =  {
      Console[F].println(s"Hello ${name} it is ${Clock[F].realTime} how are you doing?")
    }

    def talk(name: String): F[String] = Sync[F].delay(s"${name} you talk too much")
  }
}



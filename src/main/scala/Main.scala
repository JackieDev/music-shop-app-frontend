import cats.effect._
import cats.implicits._
import connectors.BackendConnector
import org.http4s.implicits._
import org.http4s.server.Router
import org.http4s.server.blaze._
import routes.{AddProductRoutes, AppRoutes}

import scala.io.StdIn

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {
    val backendConn = new BackendConnector

    val program = for {
      _   <- IO(println("Music Shop App Frontend starting"))
      productRoutes = new AppRoutes[IO](backendConn)
      addProductRoutes = new AddProductRoutes(backendConn)
      appRoutes = productRoutes.routes
      addRoutes = addProductRoutes.routes
      httpApp = Router("/" -> appRoutes, "/" -> addRoutes).orNotFound
      server = BlazeServerBuilder[IO].bindHttp(7001, "localhost").withHttpApp(httpApp)
      fiber = server.resource.use(_ => IO(StdIn.readLine())).as(ExitCode.Success)
    } yield fiber

    program.attempt.unsafeRunSync match {
      case Left(e) =>
        IO {
          println("*** An error occurred! ***")
          if (e ne null) {
            println(e.getMessage)
          }
          ExitCode.Error
        }
      case Right(r) => r
    }

  }

}

package routes

import cats.effect._
import connectors.BackendConnector
import models.MusicProduct
import io.circe.generic.auto._
import org.http4s.dsl._
import org.http4s.twirl._
import org.http4s._
import org.http4s.circe.jsonEncoderOf
import org.http4s.circe.CirceEntityEncoder._


class AppRoutes[F[_]: Sync](conn: BackendConnector
                           ) extends Http4sDsl[F] {

  implicit val entityItemEncoder: EntityEncoder[F, MusicProduct] = jsonEncoderOf[F, MusicProduct]
  implicit val decoder: EntityDecoder[F, MusicProduct] = UrlForm.entityDecoder[F].map(MusicProduct.apply)

  val routes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "home" =>
      // just render index view
      Ok(html.index(None, ""))

    case GET -> Root / "all-products" =>
      conn.getAllProducts() match {
        case m :: Nil => Ok(html.results(Some(m), ""))
        case m :: ms => Ok(html.index(Some(m :: ms), ""))
        case _ => Ok(html.results(None, ""))
      }

    case GET -> Root / "search-category" / category => {
      conn.searchByCategory(category) match {
        case m :: Nil => Ok(html.results(Some(m), ""))
        case m :: ms => Ok(html.index(Some(m :: ms), ""))
        case _ => Ok(html.results(None, ""))
      }
    }

    case GET -> Root / "search" / search => {
      conn.search(search) match {
        case list: List[MusicProduct] => {
          println(s"A list of music products were returned: $list")
          Ok(html.index(Some(list), ""))
        }

        case _ => {
          println("No products were returned")
          Ok(html.results(None, ""))
        }
      }

    }

    case GET -> Root / "status" =>
      conn.httpClient.get("http://localhost:7000/status") { response =>
        if(response.status == Status.Ok) {
          println("health check returned ok")
          IO.unit
        }
        else {
          println("health check returned not ok")
          IO.unit
        }
      }
      Ok("ping")

    case GET -> Root / "add" =>
      Ok(html.addProduct(""))
  }

}

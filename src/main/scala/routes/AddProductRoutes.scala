package routes

import cats.effect.{ContextShift, IO}
import connectors.BackendConnector
import io.circe.Encoder
import models.MusicProduct
import org.http4s.{EntityDecoder, EntityEncoder, HttpRoutes, UrlForm}
import org.http4s.dsl.io._
import org.http4s.circe.jsonEncoderOf
import play.twirl.api.HtmlFormat
import io.circe.generic.semiauto._

class AddProductRoutes(conn: BackendConnector)(implicit val cs: ContextShift[IO]) {

  implicit val encoder: EntityEncoder[IO, MusicProduct] = jsonEncoderOf[IO, MusicProduct]
  //implicit val htmlEncode: Encoder[HtmlFormat.Appendable] = deriveEncoder[HtmlFormat.Appendable]
  //implicit val htmlEncoder: EntityEncoder[IO, HtmlFormat.Appendable] = jsonEncoderOf[IO, HtmlFormat.Appendable]
  implicit val decoder: EntityDecoder[IO, MusicProduct] = UrlForm.entityDecoder[IO].map(MusicProduct.apply)

  val routes: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case request@POST -> Root / "add-product" =>
      println(s"We have hit the 'add-product' endpoint, request is: ${request}")
      request.attemptAs[MusicProduct].value.flatMap {
        case Left(error) => BadRequest(error.getMessage())
        case Right(req) => {
          //val res = conn.addProduct(req)
          //Ok(html.addProduct(res.toString))
          Ok(conn.addProduct(req))
        }
      }
  }

}

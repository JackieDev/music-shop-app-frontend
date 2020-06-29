package connectors

import cats.effect.{Blocker, ContextShift, IO, Timer}
import java.util.concurrent._

import org.http4s._
import org.http4s.dsl.io._
import org.http4s.client.dsl.io._
import io.circe.generic.auto._
import org.http4s.circe.CirceEntityEncoder._

import models.MusicProduct
import models.MusicProduct._
import io.circe.generic.auto._
import org.http4s.{EntityDecoder, EntityEncoder, Uri}
import org.http4s.client.{Client, JavaNetClientBuilder}
import org.http4s.circe._
import io.circe.syntax._

import scala.concurrent.ExecutionContext.Implicits.global

class BackendConnector {

  implicit val cs: ContextShift[IO] = IO.contextShift(global)
  implicit val timer: Timer[IO] = IO.timer(global)
  implicit val entityDecoder: EntityDecoder[IO, List[MusicProduct]] = jsonOf[IO, List[MusicProduct]]
  implicit val entityEncoder: EntityEncoder[IO, List[MusicProduct]] = jsonEncoderOf[IO, List[MusicProduct]]
  implicit val entityItemDecoder: EntityDecoder[IO, MusicProduct] = jsonOf[IO, MusicProduct]
  implicit val entityIdDecoder: EntityDecoder[IO, Int] = jsonOf[IO, Int]

  val baseUrl = "http://localhost:7000/products"
  val postUrl = "http://localhost:7000/product"
  def searchByCategoryUrl(category: String) = "http://localhost:7000/products/" + category
  val lastIdUrl = "http://localhost:7000/last-id"

  val theUri: Uri = Uri(path = postUrl, query = Query())

  val blockingPool = Executors.newFixedThreadPool(5)
  val blocker = Blocker.liftExecutorService(blockingPool)
  val httpClient: Client[IO] = JavaNetClientBuilder[IO](blocker).create

  def searchUrl(searchString: String) = baseUrl + "/search/" + searchString

//  def searchString(searchStr: String) = {
//    httpClient.expect[String](searchUrl(searchStr))
//  }

  def search(searchStr: String) = {
    httpClient.expect[List[MusicProduct]](searchUrl(searchStr)).unsafeRunSync()
  }

  def searchByCategory(category: String) =
    httpClient.expect[List[MusicProduct]](searchByCategoryUrl(category)).unsafeRunSync()

  def getAllProducts() =
    httpClient.expect[List[MusicProduct]](baseUrl).unsafeRunSync()

  def addProduct(mp: MusicProduct): MusicProduct =
    httpClient.expect[MusicProduct](POST(mp.asJson, theUri)).unsafeRunSync()

  def addProductData(form: UrlForm) =
    httpClient.expect[MusicProduct](POST(form, theUri)).unsafeRunSync()

  def getLastId =
    httpClient.expect[Int](lastIdUrl).unsafeRunSync()

}

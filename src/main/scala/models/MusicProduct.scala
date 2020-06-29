package models

import cats.data.Chain
import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import org.http4s.UrlForm
import utils.MusicProductConverter

case class MusicProduct(id: Int, name: String, description: String, price: String, category: String)

object MusicProduct {
  implicit val decode: Decoder[MusicProduct] = deriveDecoder[MusicProduct]
  implicit val encode: Encoder[MusicProduct] = deriveEncoder[MusicProduct]

  def getOutOfTheChain(chain: Chain[String]): String = {
    chain match {
      case Chain(string) => string
      case _ => "No chain found"
    }
  }

  def apply(data: UrlForm): MusicProduct = {
    println(s"------------------This is the received urlForm: $data--------------------------")
    println(s"Name is ${getOutOfTheChain(data.values.getOrElse("name", Chain()))}")
    println(s"Description is ${getOutOfTheChain(data.values.getOrElse("des", Chain()))}")
    println(s"Price is ${getOutOfTheChain(data.values.getOrElse("price", Chain()))}")
    println(s"Category is ${getOutOfTheChain(data.values.getOrElse("cat", Chain()))}")

    val id: Int = Integer.parseInt(getOutOfTheChain(data.values.getOrElse("id", Chain())))
    val n: String = getOutOfTheChain(data.values.getOrElse("name", Chain()))
    val d: String = getOutOfTheChain(data.values.getOrElse("des", Chain()))
    val p: String = getOutOfTheChain(data.values.getOrElse("price", Chain()))
    val c: String = getOutOfTheChain(data.values.getOrElse("cat", Chain()))
    //val id: Int = Math.random().toInt * 100

    MusicProductConverter.addNextId(MusicProduct(id,n,d,p,c))
  }
}

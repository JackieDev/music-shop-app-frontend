package utils

import connectors.BackendConnector
import models.MusicProduct

object MusicProductConverter {

  val conn = new BackendConnector

  def addNextId(mp: MusicProduct): MusicProduct = {
    val lastId: Int = conn.getLastId
    mp.copy(id = (lastId+1))
  }

}

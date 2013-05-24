package no.knowit.backtobasics.repository

import scala.slick.driver.DerbyDriver.simple._
//import scala.slick.driver.H2Driver.simple._
import scala.collection.JavaConversions._

import java.sql.Timestamp
import java.util.Date

import no.knowit.backtobasics.domene._

class SlickSakRepository extends SakRepository {

  import Database.threadLocalSession

  val db = Database.forURL("jdbc:derby:memory:test;create=true", driver = "org.apache.derby.jdbc.EmbeddedDriver")
//  val db = Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver")
  
  db withSession {
    SakTable.ddl.create
  }

  def taNedSakRepository {
    db withSession {
      SakTable.ddl.drop
    }
  }
  
  def opprettSak(tittel: String) = db withSession {
    val opprettet = new Timestamp(new Date().getTime())
    val id = SakTable.forInsert returning SakTable.id insert (tittel, opprettet)
    new Sak(id, tittel, opprettet)
  }
  
  def hentSak(id: Int) = db withSession {
    val q = Query(SakTable).filter(sak => sak.id === id)
    q.firstOption.map {
      case((id, tittel, opprettet)) => new Sak(id.get, tittel, opprettet)
    }.getOrElse(null)
  }
  
  def hentAlleSaker() = db withSession {
    Query(SakTable).list.map {
      case((id, tittel, opprettet)) => new Sak(id.get, tittel, opprettet)
    }
  }
  
  def oppdaterSak(sak: Sak) {}
  
  def slettSak(sak: Sak) {}
  
}

object SakTable extends Table[(Option[Int], String, Timestamp)]("SAK") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def tittel = column[String]("TITTEL")
  def opprettet = column[Timestamp]("OPPRETTET")
  
  def * = id.? ~ tittel ~ opprettet
  def forInsert = tittel ~ opprettet
}








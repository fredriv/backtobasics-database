package no.knowit.backtobasics.repository

import scala.slick.driver.DerbyDriver.simple._
import scala.collection.JavaConversions._

import java.sql.Timestamp
import java.util.Date

import no.knowit.backtobasics.domene._

class SlickSakRepository extends SakRepository {

  import Database.threadLocalSession

  val db = Database.forURL("jdbc:derby:memory:test;create=true", driver = "org.apache.derby.jdbc.EmbeddedDriver")
  
  db withSession {
    // TODO create schema
  }

  def taNedSakRepository {
    // TODO drop schema
  }
  
  def opprettSak(tittel: String) = null
  
  def hentSak(id: Int) = null
  
  def hentAlleSaker() = Nil
  
  def oppdaterSak(sak: Sak) {}
  
  def slettSak(sak: Sak) {}
  
}

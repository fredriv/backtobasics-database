package no.knowit.backtobasics.repository

import junit.framework.TestCase
import org.junit.{After, Before}

class SlickSakRepositoryTest extends SakRepositoryTest {

  private var sakRepository: SlickSakRepository = _
  
  override def getSakRepository = sakRepository
  
  @Before
  def initierSakRepository {
    sakRepository = new SlickSakRepository
  }

  @After
  def taNedSakRepository {
    sakRepository.taNedSakRepository
  }
}
package no.knowit.backtobasics.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import no.knowit.backtobasics.domene.Sak;

import org.apache.log4j.Logger;
import org.junit.Test;

public abstract class SakRepositoryTest {

    private Logger log = Logger.getLogger(SakRepositoryTest.class);

    protected abstract SakRepository getSakRepository();

    @Test
    public void opprett_sak_med_tittel() {
        Date start = new Date();
        Sak sak = getSakRepository().opprettSak("tittel");
        log.debug("Opprettet sak: " + sak);

        assertThat(sak, is(not(nullValue())));
        assertThat(sak.getTittel(), is("tittel"));
        assertThat(sak.getId(), is(greaterThan(0)));
        assertThat(sak.getOpprettet().getTime(), is(greaterThanOrEqualTo(start.getTime())));
    }

    @Test
    public void opprett_sak_med_tom_tittel() {
        Date start = new Date();
        Sak sak = getSakRepository().opprettSak("");
        log.debug("Opprettet sak: " + sak);

        assertThat(sak, is(not(nullValue())));
        assertThat(sak.getId(), is(not(nullValue())));
        assertThat(sak.getId(), is(greaterThan(0)));
        assertThat(sak.getTittel(), is(""));
        assertThat(sak.getOpprettet().getTime(), is(greaterThanOrEqualTo(start.getTime())));
    }

    @Test
    public void hent_sak() {
        Date start = new Date();
        SakRepository sakRepository = getSakRepository();
        Sak sak = sakRepository.opprettSak("tittel");

        Integer id = sak.getId();
        sak = sakRepository.hentSak(id);
        log.debug("Hentet sak: " + sak);

        assertThat(sak, is(not(nullValue())));
        assertThat(sak.getId(), is(equalTo(id)));
        assertThat(sak.getTittel(), is("tittel"));
        assertThat(sak.getOpprettet().getTime(), is(greaterThanOrEqualTo(start.getTime())));
    }

    @Test
    public void hent_alle_saker() {
        SakRepository sakRepository = getSakRepository();
        Sak sak1 = sakRepository.opprettSak("foo");
        Sak sak2 = sakRepository.opprettSak("bar");

        List<Sak> saker = sakRepository.hentAlleSaker();
        log.debug("Hentet saker: " + saker);

        assertThat(saker, is(not(nullValue())));
        assertThat(saker.size(), is(equalTo(2)));
        assertThat(saker, hasItems(sak1, sak2));
    }

}

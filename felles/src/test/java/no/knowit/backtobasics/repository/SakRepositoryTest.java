package no.knowit.backtobasics.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import no.knowit.backtobasics.domene.Sak;

import org.junit.Test;

public abstract class SakRepositoryTest {

    protected abstract SakRepository getSakRepository();
    
    @Test
    public void opprett_sak_med_tittel() {
        Date start = new Date();
        Sak sak = getSakRepository().opprettSak("tittel");
        
        assertThat(sak, is(not(nullValue())));
        assertThat(sak.getTittel(), is("tittel"));
        assertThat(sak.getId(), is(greaterThan(0)));
        assertThat(sak.getOpprettet().getTime(), is(greaterThanOrEqualTo(start.getTime())));
    }

    @Test
    public void opprett_sak_med_tom_tittel() {
        Date start = new Date();
        Sak sak = getSakRepository().opprettSak("");
        
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
        
        assertThat(sak, is(not(nullValue())));
        assertThat(sak.getId(), is(equalTo(id)));
        assertThat(sak.getTittel(), is("tittel"));
        assertThat(sak.getOpprettet().getTime(), is(greaterThanOrEqualTo(start.getTime())));
    }

}

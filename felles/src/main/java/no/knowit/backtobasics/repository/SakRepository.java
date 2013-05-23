package no.knowit.backtobasics.repository;

import java.util.List;

import no.knowit.backtobasics.domene.*;

interface SakRepository {
    
    Sak opprettSak(String tittel);

    Sak hentSak(int sakId);
    
    List<Sak> hentAlleSaker();

    void oppdaterSak(Sak sak);
    
    void slettSak(Sak sak);
    
}

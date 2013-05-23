package no.knowit.backtobasics.repository;

import java.util.List;

import no.knowit.backtobasics.domene.Sak;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSakRepository implements SakRepository {

    private SessionFactory sessionFactory;

    public HibernateSakRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void taNedSakRepository() {
        sessionFactory.close();
    }

    @Override
    public Sak opprettSak(String tittel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Sak hentSak(int sakId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Sak> hentAlleSaker() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void oppdaterSak(Sak sak) {
        // TODO Auto-generated method stub
    }

    @Override
    public void slettSak(Sak sak) {
        // TODO Auto-generated method stub
    }

}

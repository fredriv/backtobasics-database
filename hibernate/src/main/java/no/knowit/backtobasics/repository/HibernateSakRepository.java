package no.knowit.backtobasics.repository;

import java.util.Date;
import java.util.List;

import no.knowit.backtobasics.domene.Sak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Sak sak = new Sak(tittel, new Date());

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(sak);

        tx.commit();
        session.close();

        return sak;
    }

    @Override
    public Sak hentSak(int sakId) {
        Session session = sessionFactory.openSession();
        Sak sak = (Sak) session.get(Sak.class, sakId);
        session.close();
        return sak;
    }

    @Override
    public List<Sak> hentAlleSaker() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Sak> saker = session.createQuery("from Sak").list();
        session.close();
        return saker;
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

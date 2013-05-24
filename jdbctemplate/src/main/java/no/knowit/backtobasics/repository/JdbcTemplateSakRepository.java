package no.knowit.backtobasics.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import no.knowit.backtobasics.domene.Sak;

public class JdbcTemplateSakRepository implements SakRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public JdbcTemplateSakRepository() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test1");
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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

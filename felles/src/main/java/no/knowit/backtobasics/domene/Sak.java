package no.knowit.backtobasics.domene;

import java.util.Date;

public class Sak {

    private Integer id;

    private String tittel;

    private Date opprettet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public Date getOpprettet() {
        return opprettet;
    }

    public void setOpprettet(Date opprettet) {
        this.opprettet = opprettet;
    }

}

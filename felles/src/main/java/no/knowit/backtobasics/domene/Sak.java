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

    @Override
    public String toString() {
        return "Sak(" + id + ", " + tittel + ", " + opprettet + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((opprettet == null) ? 0 : opprettet.hashCode());
        result = prime * result + ((tittel == null) ? 0 : tittel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sak other = (Sak) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (opprettet == null) {
            if (other.opprettet != null)
                return false;
        } else if (other.opprettet == null) {
            return false;
        } else if (opprettet.getTime() != other.opprettet.getTime())
            return false;
        if (tittel == null) {
            if (other.tittel != null)
                return false;
        } else if (!tittel.equals(other.tittel))
            return false;
        return true;
    }

}

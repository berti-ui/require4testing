package com.require4testing.model;

import jakarta.persistence.*;

@Entity
public class Testfall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titel;
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "anforderung_id")
    private Anforderung anforderung;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public Anforderung getAnforderung() { return anforderung; }
    public void setAnforderung(Anforderung anforderung) { this.anforderung = anforderung; }
}

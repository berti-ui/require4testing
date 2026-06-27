package com.require4testing.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "testfall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Testdurchfuehrung> testdurchfuehrungen = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public Anforderung getAnforderung() { return anforderung; }
    public void setAnforderung(Anforderung anforderung) { this.anforderung = anforderung; }

    public List<Testdurchfuehrung> getTestdurchfuehrungen() { return testdurchfuehrungen; }
    public void setTestdurchfuehrungen(List<Testdurchfuehrung> td) { this.testdurchfuehrungen = td; }
}

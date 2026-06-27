package com.require4testing.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Anforderung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titel;
    private String beschreibung;

    @OneToMany(mappedBy = "anforderung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Testfall> testfaelle = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public List<Testfall> getTestfaelle() { return testfaelle; }
    public void setTestfaelle(List<Testfall> testfaelle) { this.testfaelle = testfaelle; }
}

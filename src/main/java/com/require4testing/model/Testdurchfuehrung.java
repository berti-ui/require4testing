package com.require4testing.model;

import jakarta.persistence.*;

@Entity
public class Testdurchfuehrung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "testlauf_id")
    private Testlauf testlauf;

    @ManyToOne
    @JoinColumn(name = "testfall_id")
    private Testfall testfall;

    private String testerName;

    @Enumerated(EnumType.STRING)
    private Ergebnis ergebnis = Ergebnis.AUSSTEHEND;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Testlauf getTestlauf() { return testlauf; }
    public void setTestlauf(Testlauf testlauf) { this.testlauf = testlauf; }

    public Testfall getTestfall() { return testfall; }
    public void setTestfall(Testfall testfall) { this.testfall = testfall; }

    public String getTesterName() { return testerName; }
    public void setTesterName(String testerName) { this.testerName = testerName; }

    public Ergebnis getErgebnis() { return ergebnis; }
    public void setErgebnis(Ergebnis ergebnis) { this.ergebnis = ergebnis; }
}

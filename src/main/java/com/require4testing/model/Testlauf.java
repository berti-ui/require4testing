package com.require4testing.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Testlauf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate erstellungsdatum;

    @OneToMany(mappedBy = "testlauf", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Testdurchfuehrung> testdurchfuehrungen = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getErstellungsdatum() { return erstellungsdatum; }
    public void setErstellungsdatum(LocalDate erstellungsdatum) { this.erstellungsdatum = erstellungsdatum; }

    public List<Testdurchfuehrung> getTestdurchfuehrungen() { return testdurchfuehrungen; }
    public void setTestdurchfuehrungen(List<Testdurchfuehrung> testdurchfuehrungen) { this.testdurchfuehrungen = testdurchfuehrungen; }
}

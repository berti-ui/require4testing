package com.require4testing.controller;

import com.require4testing.model.Ergebnis;
import com.require4testing.model.Testdurchfuehrung;
import com.require4testing.repository.TestdurchfuehrungRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestdurchfuehrungController {

    private final TestdurchfuehrungRepository repository;

    public TestdurchfuehrungController(TestdurchfuehrungRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/testdurchfuehrungen")
    public String liste(Model model) {
        model.addAttribute("testdurchfuehrungen", repository.findAll());
        model.addAttribute("ergebnisse", Ergebnis.values());
        return "testdurchfuehrungen";
    }

    @PostMapping("/testdurchfuehrungen/{id}/ergebnis")
    public String ergebnisSetzen(@PathVariable Long id, @RequestParam Ergebnis ergebnis) {
        Testdurchfuehrung td = repository.findById(id).orElseThrow();
        td.setErgebnis(ergebnis);
        repository.save(td);
        return "redirect:/testdurchfuehrungen";
    }
}

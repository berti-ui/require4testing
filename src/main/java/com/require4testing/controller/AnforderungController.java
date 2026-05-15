package com.require4testing.controller;

import com.require4testing.model.Anforderung;
import com.require4testing.repository.AnforderungRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnforderungController {

    private final AnforderungRepository repository;

    public AnforderungController(AnforderungRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/anforderungen")
    public String liste(Model model) {
        model.addAttribute("anforderungen", repository.findAll());
        return "anforderungen";
    }

    @GetMapping("/anforderungen/neu")
    public String neueAnforderungForm(Model model) {
        model.addAttribute("anforderung", new Anforderung());
        return "anforderung-form";
    }

    @PostMapping("/anforderungen")
    public String speichern(@ModelAttribute Anforderung anforderung) {
        repository.save(anforderung);
        return "redirect:/anforderungen";
    }

    @GetMapping("/anforderungen/{id}/bearbeiten")
    public String bearbeitenForm(@PathVariable Long id, Model model) {
        model.addAttribute("anforderung", repository.findById(id).orElseThrow());
        return "anforderung-form";
    }

    @PostMapping("/anforderungen/{id}/bearbeiten")
    public String aktualisieren(@PathVariable Long id, @ModelAttribute Anforderung anforderung) {
        anforderung.setId(id);
        repository.save(anforderung);
        return "redirect:/anforderungen";
    }

    @PostMapping("/anforderungen/{id}/loeschen")
    public String loeschen(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/anforderungen";
    }
}

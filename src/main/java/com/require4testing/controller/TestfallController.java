package com.require4testing.controller;

import com.require4testing.model.Testfall;
import com.require4testing.repository.AnforderungRepository;
import com.require4testing.repository.TestfallRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestfallController {

    private final TestfallRepository testfallRepository;
    private final AnforderungRepository anforderungRepository;

    public TestfallController(TestfallRepository testfallRepository, AnforderungRepository anforderungRepository) {
        this.testfallRepository = testfallRepository;
        this.anforderungRepository = anforderungRepository;
    }

    @GetMapping("/testfaelle")
    public String liste(Model model) {
        model.addAttribute("testfaelle", testfallRepository.findAll());
        return "testfaelle";
    }

    @GetMapping("/testfaelle/neu")
    public String neuerTestfallForm(Model model) {
        model.addAttribute("testfall", new Testfall());
        model.addAttribute("anforderungen", anforderungRepository.findAll());
        return "testfall-form";
    }

    @PostMapping("/testfaelle")
    public String speichern(@ModelAttribute Testfall testfall,
                            @RequestParam(required = false) Long anforderungId) {
        if (anforderungId != null) {
            anforderungRepository.findById(anforderungId).ifPresent(testfall::setAnforderung);
        }
        testfallRepository.save(testfall);
        return "redirect:/testfaelle";
    }

    @PostMapping("/testfaelle/{id}/loeschen")
    public String loeschen(@PathVariable Long id) {
        testfallRepository.deleteById(id);
        return "redirect:/testfaelle";
    }
}

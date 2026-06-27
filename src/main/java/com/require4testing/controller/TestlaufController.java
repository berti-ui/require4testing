package com.require4testing.controller;

import com.require4testing.model.Testdurchfuehrung;
import com.require4testing.model.Testlauf;
import com.require4testing.repository.TestdurchfuehrungRepository;
import com.require4testing.repository.TestfallRepository;
import com.require4testing.repository.TestlaufRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class TestlaufController {

    private final TestlaufRepository testlaufRepository;
    private final TestfallRepository testfallRepository;
    private final TestdurchfuehrungRepository testdurchfuehrungRepository;

    public TestlaufController(TestlaufRepository testlaufRepository,
                               TestfallRepository testfallRepository,
                               TestdurchfuehrungRepository testdurchfuehrungRepository) {
        this.testlaufRepository = testlaufRepository;
        this.testfallRepository = testfallRepository;
        this.testdurchfuehrungRepository = testdurchfuehrungRepository;
    }

    @GetMapping("/testlaeufe")
    public String liste(Model model) {
        model.addAttribute("testlaeufe", testlaufRepository.findAll());
        return "testlaeufe";
    }

    @GetMapping("/testlaeufe/neu")
    public String neuerTestlaufForm(Model model) {
        model.addAttribute("testlauf", new Testlauf());
        return "testlauf-form";
    }

    @PostMapping("/testlaeufe")
    public String speichern(@ModelAttribute Testlauf testlauf) {
        testlaufRepository.save(testlauf);
        return "redirect:/testlaeufe";
    }

    @GetMapping("/testlaeufe/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Testlauf testlauf = testlaufRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("testlauf", testlauf);
        model.addAttribute("testfaelle", testfallRepository.findAll());
        return "testlauf-detail";
    }

    @PostMapping("/testlaeufe/{id}/zuordnen")
    public String zuordnen(@PathVariable Long id,
                            @RequestParam Long testfallId,
                            @RequestParam String testerName) {
        Testlauf testlauf = testlaufRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Testdurchfuehrung td = new Testdurchfuehrung();
        td.setTestlauf(testlauf);
        td.setTestfall(testfallRepository.findById(testfallId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        td.setTesterName(testerName);
        testdurchfuehrungRepository.save(td);
        return "redirect:/testlaeufe/" + id;
    }

    @PostMapping("/testlaeufe/{id}/loeschen")
    public String loeschen(@PathVariable Long id) {
        testlaufRepository.deleteById(id);
        return "redirect:/testlaeufe";
    }
}

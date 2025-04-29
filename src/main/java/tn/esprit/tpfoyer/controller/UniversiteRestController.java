package tn.esprit.tpfoyer.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteRestController {

    private final IUniversiteService universiteService;

    public UniversiteRestController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversite();
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") long uId) {
        return universiteService.retrieveUniversite(uId);
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite e) {
        return universiteService.addUniversite(e);
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") long uId) {
        universiteService.removeUniversite(uId);
    }

    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite e) {
        return universiteService.modifyUniversite(e);
    }
}
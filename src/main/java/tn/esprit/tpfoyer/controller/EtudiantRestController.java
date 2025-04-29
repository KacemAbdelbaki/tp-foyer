package tn.esprit.tpfoyer.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {

    private final IEtudiantService etudiantService;

    public EtudiantRestController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantService.retrieveAllEtudiant();
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") long eId) {
        return etudiantService.retrieveEtudiant(eId).get();
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") long eId) {
        etudiantService.removeEtudiant(eId);
    }

    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        return etudiantService.modifyEtudiant(e);
    }

    @GetMapping("/retrieve-etudiant/university/")
    public List<Etudiant> retrieveEtudiantByNumC(@RequestBody() Universite universite) {
        return etudiantService.findAllByUniversite(universite);
    }
}
package tn.esprit.tpfoyer.controller;

<<<<<<< HEAD
=======
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
>>>>>>> 8c169da6eaa5fbd6f717b89fe3721b055200fa92
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.service.IChambreService;
import tn.esprit.tpfoyer.service.IEtudiantService;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@Tag(name="Gestion Chambre")
@RestController
@RequestMapping("/chambre")
public class ChambreRestController {

    private final IChambreService chambreService;
    private final IReservationService reservationService;
    private final IEtudiantService etudiantService;

    public ChambreRestController(IChambreService chambreService, IReservationService reservationService, IEtudiantService etudiantService) {
        this.chambreService = chambreService;
        this.reservationService = reservationService;
        this.etudiantService = etudiantService;
    }

    @Operation(description = "Recuperer toutes les chambres")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") long chId) {
        return chambreService.retrieveChambre(chId);
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        System.out.println(c.getReservations());
        return chambreService.addChambre(c);
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") long chId) {
        chambreService.removeChambre(chId);
    }

    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        return chambreService.modifyChambre(c);
    }

    @GetMapping("/retrieve-chambre/type/{chambre-type}")
    public List<Chambre> retrieveChambreByType(@PathVariable("chambre-type") TypeChambre typeC) {
        return chambreService.findAllByType(typeC);
    }

    @GetMapping("/retrieve-chambre/numC/{num-chambre}")
    public Chambre retrieveChambreByNumC(@PathVariable("num-chambre") Long numC) {
        return chambreService.findChambreByNumeroChambre(numC);
    }

    @GetMapping("/retrieve-chambre/etudiant/{cin}")
    public Chambre retrieveChambreByEtudiant(@PathVariable("cin") Long cin) {
        return chambreService.findChambreByNumeroChambre(cin);
    }
}
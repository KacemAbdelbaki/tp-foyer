package tn.esprit.tpfoyer.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IEtudiantService;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

    private final IReservationService reservationService;
    private final IEtudiantService etudiantService;

    public ReservationRestController(IReservationService reservationService, IEtudiantService etudiantService) {
        this.reservationService = reservationService;
        this.etudiantService = etudiantService;
    }

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservation();
    }

    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String chId) {
        return reservationService.retrieveReservation(chId);
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
//        for(var el: c.getEtudiants()){
//            this.etudiantService.addEtudiant(el);
//        }
        return reservationService.addReservation(c);
    }

    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String chId) {
        reservationService.removeReservation(chId);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        return reservationService.modifyReservation(c);
    }
}
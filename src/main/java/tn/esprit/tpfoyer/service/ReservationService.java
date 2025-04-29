package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationService implements IReservationService{

    private final ReservationRepository reservationRepository;

//    public ReservationService(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }

    @Override
    public List<Reservation> retrieveAllReservation() {
        return this.reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(String reservationId) {
        return this.reservationRepository.findById(reservationId).get();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return this.reservationRepository.save(r);
    }

    @Override
    public void removeReservation(String reservationId) {
        this.reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Scheduled(fixedDelay = 60000)
    public void mettreAJourEtAfficherReservations(){
        Date d = new Date();
        for(var reservation: reservationRepository.findAll()){
            if(reservation.getAnneeUniversitaire().before(new Date(2024, Calendar.JANUARY,1))){
                log.info("-------------------NEW_ENTITY-------------------");
                log.info("-------------------BEFORE-------------------");
                log.info(reservation.toString());
                reservation.setEstValide(false);
                this.reservationRepository.save(reservation);
                log.info("-------------------AFTER-------------------");
                log.info(reservation.toString());
            }
        }
    }
}

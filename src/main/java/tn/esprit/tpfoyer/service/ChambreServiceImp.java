package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreServiceImp implements IChambreService {

    @Autowired
    private final ChambreRepository chambreRepository;

    @Autowired
    private final BlocRepository blocRepository;

    @Override
    @Scheduled(fixedDelay = 60000)
//    @Scheduled(cron= "0/30 * * * * *")
    public List<Chambre> retrieveAllChambres() {
        List<Chambre> chambreList = chambreRepository.findAll();
        for(Chambre chambre: chambreList){
            log.info(chambre.toString());
        }
        return chambreList;
    }

    @Override
    public Chambre retrieveChambre(long chambreId) {
        return chambreRepository.findById(chambreId).orElse(null);
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> findAllByType(TypeChambre typeChambre) {
        return chambreRepository.findAllByTypeC(typeChambre);
    }

    @Override
    public Chambre findChambreByNumeroChambre(long numC){
        return this.chambreRepository.findChambreByNumeroChambre(numC);
    }

    @Override
    public Chambre findChambreByEtudiant(long cin) {
        return this.chambreRepository.trouverChselonEt(cin);
    }

    @Override
    public List<Chambre> findChambreByBloc(Long idBloc){
        return chambreRepository.findChambreByBloc(blocRepository.findById(idBloc).get());
    }

    @Scheduled( fixedDelay = 10000)
    public void pourcentageChambreByTypeChambre(){
        Map<TypeChambre, Double> pourcentage = new HashMap<>();
        double totaleC = chambreRepository.findAll().size();
        for(TypeChambre type: TypeChambre.values()){
            pourcentage.put(type,(chambreRepository.findChambreByTypeC(type).size()/totaleC)*100);
        }
        log.info("nombre totale des chambre: " + totaleC);
        for(TypeChambre type: TypeChambre.values()){
            log.info("pourcentage de type: " + type + " = " + pourcentage.get(type));
        }
    }

    @Scheduled( fixedDelay = 1000)
    @Transactional
    public void nbPlaceDisponible() {
        for (var el: chambreRepository.findAll())
            for (var el2: el.getReservations()){
                System.out.println(el2.isEstValide());
            }
    }
}

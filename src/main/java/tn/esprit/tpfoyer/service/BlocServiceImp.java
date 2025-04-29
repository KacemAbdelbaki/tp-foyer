package tn.esprit.tpfoyer.service;

import ch.qos.logback.core.util.FixedDelay;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BlocServiceImp implements IBlocService{
    @Autowired
    BlocRepository blocRepository;

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    ChambreServiceImp chambreService;

    @Override
    @Scheduled(fixedDelay = 60000) //toute les minutes
    public List<Bloc> retrieveAllBloc() {
        List<Bloc> listBloc = blocRepository.findAll();
        for(var bloc: listBloc)
            log.info(bloc.toString());
        return listBloc;
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Scheduled(fixedDelay = 10000) //reminder to change the time to each minute (60,000)
    public void listChambreParBloc(){
        for(Bloc bloc: blocRepository.findAll()){
            log.info("Bloc => "+ bloc.getNomBloc() + " ayant une capacite "+bloc.getCapaciteBloc());
            log.info("la liste des chambres pour ce bloc: ");
            if(!chambreService.findChambreByBloc(bloc.getIdBloc()).isEmpty()){
                for(Chambre chambre: chambreService.findChambreByBloc(bloc.getIdBloc())){
                    log.info("Num Chambre: "+ chambre.getNumeroChambre() + " type: " + chambre.getTypeC());
                }
            }
            else {
                log.info("Pas de chambre disponible");
            }
        }
    }

}

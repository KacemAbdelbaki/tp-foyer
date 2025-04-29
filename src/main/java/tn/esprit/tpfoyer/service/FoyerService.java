package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepository;
    @Autowired
    BlocRepository blocRepository;
    @Override
    public List<Foyer> retrieveAllFoyer() {
        return null;
    }

    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        return null;
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long foyerId) {

    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return null;
    }
}

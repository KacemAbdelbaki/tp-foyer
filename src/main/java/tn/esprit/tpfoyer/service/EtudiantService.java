package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    private final EtudiantRepository etudiantRepository;

//    public EtudiantService(EtudiantRepository etudiantRepository){
//        this.etudiantRepository=etudiantRepository;
//    }
    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long etudiantId) {;
        return etudiantRepository.findById(etudiantId).get();
    }

    @Override
    public Etudiant addEtudiant(Etudiant c) {
        return etudiantRepository.save(c);
    }

    @Override
    public void removeEtudiant(Long chambreId) {
        etudiantRepository.deleteById(chambreId);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> findAllByUniversite(Universite universite) {
        return this.etudiantRepository.findAllByUniversite(universite);
    }
}

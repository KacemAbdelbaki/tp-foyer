package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiant();
    public Etudiant retrieveEtudiant(Long etudiantId);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long chambreId);
    public Etudiant modifyEtudiant(Etudiant etudiant);
    public List<Etudiant> findAllByUniversite(Universite universite);
}

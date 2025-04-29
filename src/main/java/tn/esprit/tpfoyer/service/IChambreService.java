package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public List<Chambre> findAllByType(TypeChambre typeChambre);
    public Chambre findChambreByNumeroChambre(long numC);
    public Chambre findChambreByEtudiant(long cin);
    public List<Chambre> findChambreByBloc(Long idBloc);
}

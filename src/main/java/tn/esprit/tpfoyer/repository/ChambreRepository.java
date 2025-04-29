package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    public List<Chambre> findAllByTypeC(TypeChambre typeC);
    public Chambre findChambreByNumeroChambre(long numC);
    @Query("SELECT distinct (ch) FROM Chambre ch " +
            "INNER JOIN ch.reservations r " +
            "INNER JOIN r.etudiants e " +
            "WHERE e.cin=:cin " )
    Chambre trouverChselonEt(long cin);

    public List<Chambre> findChambreByBloc(Bloc bloc);

    public List<Chambre> findChambreByTypeC(TypeChambre typeC);
}

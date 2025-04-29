package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToOne
    private Bloc bloc;

//    @Override
//    public String toString() {
//        return "Chambre{" +
//                "idChambre=" + idChambre +
//                ", numeroChambre=" + numeroChambre +
//                ", typeC=" + typeC +
//                ", reservations=" + reservations +
//                ", bloc=" + bloc +
//                '}';
//    }
}

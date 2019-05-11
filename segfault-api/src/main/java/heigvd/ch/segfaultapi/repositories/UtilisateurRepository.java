package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    List<Utilisateur> findBynomUtilisateurStartingWith(String nomUtilisateur);
    Optional<Utilisateur> findByNomUtilisateurEquals(String nomUtilisateur);
}

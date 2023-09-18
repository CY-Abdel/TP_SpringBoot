package fr.vde.tpspring.repository;

import fr.vde.tpspring.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Etudiant findByEmail(String email);
    Etudiant findByName(String nom);
    void deleteByName(String nom);

}

package fr.vde.tpspring.service;

import fr.vde.tpspring.entities.Etudiant;
import fr.vde.tpspring.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    private EtudiantRepository etudiantRepository;

    //    constructeur
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    public void creer(Etudiant etudiant) {
        // on gere le cas ou l'etudiant qu"on veut ajouter existe deja dans la base de données
        // on a choisi de mettre le email (non null et unique pour faire la recherche par email
        // on doit egalement definir la methode findByEmail dans le repository
        Etudiant etudiantInBDD = this.etudiantRepository.findByEmail(etudiant.getEmail());
        // si l'etudiant n'existe pas dans la BDD alors on va le créer
        if (etudiantInBDD == null) {
            this.etudiantRepository.save(etudiant);
        }
    }
    public List<Etudiant> lireAll() {
        return this.etudiantRepository.findAll();
    }
}

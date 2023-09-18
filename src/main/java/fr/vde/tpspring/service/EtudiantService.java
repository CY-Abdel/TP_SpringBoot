package fr.vde.tpspring.service;

import fr.vde.tpspring.entities.Etudiant;
import fr.vde.tpspring.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Etudiant lireOne(int id) {
        // on retourne l'etudiant s'il existe sinon null
        Optional<Etudiant> etudiantById = this.etudiantRepository.findById(id);
        return etudiantById.orElse(null);
    }

    private Etudiant lireOne(String nom) {
        // on retourne l'etudiant s'il existe sinon null
        Etudiant etudiantInBDD = etudiantRepository.findByName(nom);
        if (etudiantInBDD == null){
            return null;
        }
        return etudiantInBDD;
    }

    public void supprimer(String nom) {
        this.etudiantRepository.deleteByName(nom);
    }

    public void modifier(String nom, Etudiant etudiant) {
        // on recupere le Etudiant de la BDD
        Etudiant etudiantAModifier = this.lireOne(nom);

        // on peut verifier que le etudiant de la BDD a modifier == etudiant donné en parametre a modifier
        if (etudiantAModifier.getId() == etudiant.getId()) {
            // on va modifier son email et son tel , nom et adrese
            etudiantAModifier.setNom(etudiant.getNom());
            etudiantAModifier.setEmail(etudiant.getEmail());
            etudiantAModifier.setTel(etudiant.getTel());
            etudiantAModifier.setAdresse(etudiant.getAdresse());
            // ne pas oublier de l'enregistrer sinon les modif ne seront pas exectuer
            this.etudiantRepository.save(etudiantAModifier);
        }
    }
}

package fr.vde.tpspring.service;

import fr.vde.tpspring.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

@Service
public class EtudiantService {
    private EtudiantRepository etudiantRepository;

    //    constructeur
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
}

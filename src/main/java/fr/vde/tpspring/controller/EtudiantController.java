package fr.vde.tpspring.controller;

import fr.vde.tpspring.service.EtudiantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "etudiant")
public class EtudiantController {
    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
}

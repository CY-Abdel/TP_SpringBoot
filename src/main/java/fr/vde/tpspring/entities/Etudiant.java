package fr.vde.tpspring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ETUDIANT")
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int tel;

    private String adresse;


}

package com.simplon.etudiantsw.controller;

import com.simplon.etudiantsw.dao.impl.EtudiantsRepository;
import com.simplon.etudiantsw.entity.Etudiants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantsController {

    private final EtudiantsRepository repo;

    public  EtudiantsController(EtudiantsRepository fr){
        this.repo = fr;
    }

    @GetMapping("/rest/etudiants")
    public List<Etudiants> getEtudiants() {
        return repo.findAll();
    }

    @PostMapping("/rest/etudiants")
    public  Etudiants addEtudiants(@RequestBody Etudiants newEtudiant){
        return repo.save(newEtudiant);
    }

    @GetMapping("/rest/etudiants/{id}")
    public Etudiants getEtudiant(@PathVariable long id){
        return repo.findById(id).orElse(new Etudiants("Inconnu", "inconnu", 0, "inconnu"));
    }

    @DeleteMapping("/rest/etudiants/{id}")
    public void delEtudiant(@PathVariable long id){
        repo.deleteById(id);
    }

    @PutMapping("/rest/etudiants/{id}")
    public Etudiants updateEtudiant(@RequestBody Etudiants newEtudiant, @PathVariable long id) {
        return repo.findById(id)
                .map(etudiants -> {
                    etudiants.setNom(newEtudiant.getNom());
                    etudiants.setPrenom(newEtudiant.getPrenom());
                    etudiants.setAge(newEtudiant.getAge());
                    etudiants.setClasse(newEtudiant.getClasse());
                    return  repo.save(etudiants);
                })
                .orElseGet(() -> {
                    newEtudiant.setId(id);
                    return repo.save(newEtudiant);
                });
    }
}

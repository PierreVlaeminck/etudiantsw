package com.simplon.etudiantsw.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "etudiants")
public class Etudiants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private double age;

    private String classe;

    public Etudiants(String nom, String prenom, double age, String classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.classe = classe;
    }

    public Etudiants() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
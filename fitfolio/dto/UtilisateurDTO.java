package com.example.fitfolio.dto;

import com.example.fitfolio.entity.DateE;

public class UtilisateurDTO {
    private Long matricule;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String motDePasse;
    private int age;
    private String sexe;
    private float poids;
    private float taille;
    private String objectif;
    private DateE id_date; 
  
    public UtilisateurDTO() {
    }

    public UtilisateurDTO(Long matricule, String nom, String prenom, String telephone, String email, String motDePasse,
                          int age, String sexe, float poids, float taille, String objectif, DateE id_date) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.motDePasse = motDePasse;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.objectif = objectif;
        this.id_date = id_date;
    }

    

    public Long getMatricule() {
        return matricule;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public DateE getId_date() {
        return id_date;
    }

    public void setId_date(DateE id_date) {
        this.id_date = id_date;
    }
}

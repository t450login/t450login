package com.example.fitfolio.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Utilisateur {

	@Id
    @Column(name="matricule")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricule;

    @Column(name="nom", length = 25)
    private String nom;

    @Column(name="prenom", length = 25)
    private String prenom;

    @Column(name="telephone", length = 25)
    private String telephone;

    @Column(name="email", length = 50, unique=true)
    private String email;

    @Column(name="mot_de_passe", length = 50)
    private String motDePasse;

    @Column(name="age")
    private int age;

    @Column(name="sexe", length = 25)
    private String sexe;

    @Column(name="poids")
    private float poids;

    @Column(name="taille")
    private float taille;
    
    @Column(name="objectif", length = 50)
    private String objectif;
    
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "fk_id_date")
    private DateE id_date;


    public Utilisateur() {
    }

    public Utilisateur(Long matricule, String nom, String prenom, String telephone, String email, String motDePasse,
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

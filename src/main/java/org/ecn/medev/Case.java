package org.ecn.medev;

public abstract class Case {
    String nom;
    
    public Case(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Case{" +
                "nom='" + nom + '\'' +
                '}';
    }
}

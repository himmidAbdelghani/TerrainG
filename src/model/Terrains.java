/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hp
 */
public class Terrains {
private int id;
	private String Nom;
	private String Adresse;
	private String Superficie;
        private String Disponibilite;
        private String type;

    public Terrains(int id, String Nom, String Adresse, String Superficie, String Disponibilite, String type) {
        this.id = id;
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Superficie = Superficie;
        this.Disponibilite = Disponibilite;
        this.type = type;
    }

    public Terrains() {
        super();
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the Adresse
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @param Adresse the Adresse to set
     */
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    /**
     * @return the Superficie
     */
    public String getSuperficie() {
        return Superficie;
    }

    /**
     * @param Superficie the Superficie to set
     */
    public void setSuperficie(String Superficie) {
        this.Superficie = Superficie;
    }

    /**
     * @return the Disponibilite
     */
    public String getDisponibilite() {
        return Disponibilite;
    }

    /**
     * @param Disponibilite the Disponibilite to set
     */
    public void setDisponibilite(String Disponibilite) {
        this.Disponibilite = Disponibilite;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
        

    
    
}

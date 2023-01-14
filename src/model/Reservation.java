/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

public class Reservation {

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
     * @return the date_reservation
     */
    public Date getDate_reservation() {
        return date_reservation;
    }

    /**
     * @param date_reservation the date_reservation to set
     */
    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    /**
     * @return the heure_d
     */
    public Date getHeure_d() {
        return heure_d;
    }

    /**
     * @param heure_d the heure_d to set
     */
    public void setHeure_d(Date heure_d) {
        this.heure_d = heure_d;
    }

    /**
     * @return the heure_f
     */
    public Date getHeure_f() {
        return heure_f;
    }

    /**
     * @param heure_f the heure_f to set
     */
    public void setHeure_f(Date heure_f) {
        this.heure_f = heure_f;
    }

    /**
     * @return the nom_terrain
     */
    public String getNom_terrain() {
        return nom_terrain;
    }

    /**
     * @param nom_terrain the nom_terrain to set
     */
    public void setNom_terrain(String nom_terrain) {
        this.nom_terrain = nom_terrain;
    }

    /**
     * @return the nom_Assoc
     */
    public String getNom_Assoc() {
        return nom_Assoc;
    }

    /**
     * @param nom_Assoc the nom_Assoc to set
     */
    public void setNom_Assoc(String nom_Assoc) {
        this.nom_Assoc = nom_Assoc;
    }

    /**
     * @return the document_identite
     */
    public String getDocument_identite() {
        return document_identite;
    }

    /**
     * @param document_identite the document_identite to set
     */
    public void setDocument_identite(String document_identite) {
        this.document_identite = document_identite;
    }

    /**
     * @return the imatricule_transp
     */
    public String getImatricule_transp() {
        return imatricule_transp;
    }

    /**
     * @param imatricule_transp the imatricule_transp to set
     */
    public void setImatricule_transp(String imatricule_transp) {
        this.imatricule_transp = imatricule_transp;
    }
  private int id;
  private Date date_reservation;
  private Date heure_d;
  private Date heure_f;
  private String nom_terrain;
  private String nom_Assoc;
  private String document_identite;
  private String imatricule_transp;

    public Reservation(int id, Date date_reservation, Date heure_d, Date heure_f, String nom_terrain, String nom_Assoc, String document_identite, String imatricule_transp) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.heure_d = heure_d;
        this.heure_f = heure_f;
        this.nom_terrain = nom_terrain;
        this.nom_Assoc = nom_Assoc;
        this.document_identite = document_identite;
        this.imatricule_transp = imatricule_transp;
    }

 
}
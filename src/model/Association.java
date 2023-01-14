/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Association {
    private int id_Assoc;
    private String nom_Assoc;
    private String domaine_activite;
    private String nom_respo;
    private String code_unique;
    private String email_Assoc;
    private String username;
    private String password;
    private String telephone;

    public Association(int id_Assoc, String nom_Assoc, String domaine_activite, String nom_respo, String code_unique, String email_Assoc, String username, String password, String telephone) {
        this.id_Assoc = id_Assoc;
        this.nom_Assoc = nom_Assoc;
        this.domaine_activite = domaine_activite;
        this.nom_respo = nom_respo;
        this.code_unique = code_unique;
        this.email_Assoc = email_Assoc;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
    }

    public Association() {
        super();
    }
    /**
     * @return the id_Assoc
     */
    public int getId_Assoc() {
        return id_Assoc;
    }

    /**
     * @param id_Assoc the id_Assoc to set
     */
    public void setId_Assoc(int id_Assoc) {
        this.id_Assoc = id_Assoc;
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
     * @return the domaine_activite
     */
    public String getDomaine_activite() {
        return domaine_activite;
    }

    /**
     * @param domaine_activite the domaine_activite to set
     */
    public void setDomaine_activite(String domaine_activite) {
        this.domaine_activite = domaine_activite;
    }

    /**
     * @return the nom_respo
     */
    public String getNom_respo() {
        return nom_respo;
    }

    /**
     * @param nom_respo the nom_respo to set
     */
    public void setNom_respo(String nom_respo) {
        this.nom_respo = nom_respo;
    }

    /**
     * @return the code_unique
     */
    public String getCode_unique() {
        return code_unique;
    }

    /**
     * @param code_unique the code_unique to set
     */
    public void setCode_unique(String code_unique) {
        this.code_unique = code_unique;
    }

    /**
     * @return the email_Assoc
     */
    public String getEmail_Assoc() {
        return email_Assoc;
    }

    /**
     * @param email_Assoc the email_Assoc to set
     */
    public void setEmail_Assoc(String email_Assoc) {
        this.email_Assoc = email_Assoc;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    

    
}

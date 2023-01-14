/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class transport {

    /**
     * @return the disponibilite
     */
    
        private int Id_transp;
	private String marque;
	private String immatricule;
	private String model;
        private String disponibilite;

        
        
        public  transport(){
          super();
        }
        
        public transport(int Id_transp,String marque,String immatricule,String model,String disponibilite){
            super();
            this.Id_transp = Id_transp;
            this.marque = marque;
            this.model = model;
            this.immatricule =immatricule;
            this.disponibilite = disponibilite;
        }
    /**
     * @return the Id_transp
     */
    public int getId_transp() {
        return Id_transp;
    }

    /**
     * @param Id_transp the Id_transp to set
     */
    public void setId_transp(int Id_transp) {
        this.Id_transp = Id_transp;
    }

    /**
     * @return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the immatricule
     */
    public String getImmatricule() {
        return immatricule;
    }

    /**
     * @param immatricule the immatricule to set
     */
    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
        
    public String getDisponibilite() {
        return disponibilite;
    }

    /**
     * @param disponibilite the disponibilite to set
     */
    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }
}

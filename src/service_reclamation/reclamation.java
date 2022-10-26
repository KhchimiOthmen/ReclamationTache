/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_reclamation;

/**
 *
 * @author khchi
 */
public class reclamation {
    private int id;
    private int client_id;
    private String sujet;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public reclamation(int id, int client_id, String sujet, String description) {
        this.id = id;
        this.client_id = client_id;
        this.sujet = sujet;
        this.description = description;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id=" + id + ", client_id=" + client_id + ", sujet=" + sujet + ", description=" + description + '}';
    }
    
}

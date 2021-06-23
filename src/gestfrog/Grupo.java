/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestfrog;

/**
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

/**
 *
 * @author Oscar Alejandro
 */
public class Grupo {

    int id;
    String descripcion;
    boolean disponible;
    // Usuario usuario;

    public Grupo() {
    }

    public Grupo(int id, String desc, boolean disp) {
        this.id = id;
        this.descripcion = desc;
        this.disponible = disp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTerminada() {
        return disponible;
    }

    public void setTerminada(boolean disp) {
        this.disponible = disp;
    }

    // Grupo grupo = new Grupo();
}

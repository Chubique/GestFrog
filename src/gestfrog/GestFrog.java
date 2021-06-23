/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestfrog;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar Alejandro
 */
public class GestFrog {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        // TODO code application logic heretry {
        UsuarioMenu panel2 = new UsuarioMenu();
        Menu panel1 = new Menu();
        panel1.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel1.setVisible(false);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel2.setVisible(true);



    }

}

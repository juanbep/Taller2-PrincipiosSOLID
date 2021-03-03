/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

/**
 *
 * @author Beca98
 */
public class Utilities {

    public Utilities() {
    }
    
    /*
    * Método para el sorteo: verifica si el camion pudo acertarle a un número aleatorio de entre 1 y 1000
    */
    public boolean winDraw(int parNumber) {
        int varNumber = (int) (Math.random() * 1000 + 1);
        return parNumber == varNumber;
    }
}

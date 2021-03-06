/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

/**
 * Vehiculo del parqueadero: carro, moto o camión
 *
 * @author Beca98
 */
public class Vehicle {

    // Placa
    private String plate;

    // Tipo; carro, moto, camion
    private TypeEnum type;

    /**
     * Constructor Parametrizado plate : placa del vehiculo type : tipo de
     * vehiculo
     *
     * @param plate parametro que recibe la placa
     * @param type parametro que recibe el tipo de vehiculo
     */
    public Vehicle(String plate, TypeEnum type) {
        this.plate = plate;
        this.type = type;
    }

    /**
     * Constructor por defecto
     */
    public Vehicle() {

    }

    /**
     * Métodos getter: placa
     *
     * @return la placa
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Método getter: type
     *
     * @return el tipo de vehiculo
     */
    public TypeEnum getType() {
        return type;
    }

    /**
     * Método setter
     *
     * @param plate parametro tipo string que recibe la placa del vehiculo
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * Método setter
     *
     * @param type parametro que recibe el tipo de vehiculo
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "Vehicle{" + "plate=" + plate + ", type=" + type + '}';
    }

}

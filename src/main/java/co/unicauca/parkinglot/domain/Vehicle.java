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

    /**
     * Placa
     */
    private String plate;
    /**
     * Tipo; carro, moto, camion
     */
    private TypeEnum type;

    /**
     * Constructor Parametrizado plate : placa del vehiculo type : tipo de
     * vehiculo
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
     * Métodos getters
     *
     * @return
     */
    public String getPlate() {
        return plate;
    }

    public TypeEnum getType() {
        return type;
    }

    /**
     * Métodos setters
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

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

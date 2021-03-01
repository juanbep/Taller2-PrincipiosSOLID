/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.access.VehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class Service {

    private IVehicleRepository repository;

    /**
     * Constructor por defecto de la clase Service.
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Lógica de acceso a datos
     *
     * @param parNewVehicle , Vehiculo a ser almacenado en la Base de datos.
     * @return true si fue posible guardar el producto, false en caso contrario.
     */
    public boolean saveVehicle(Vehicle parNewVehicle) {

        if (parNewVehicle == null || parNewVehicle.getPlate().isEmpty()) {
            return false;
        }
        repository.saveVehicle(parNewVehicle);
        return true;
    }

    /**
     * Funcion encargada de recibir lista de los vehiculos almacenados en la
     * base de datos.
     *
     * @return Retorna lista de vehiculos almacenados en la base de datos.
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> listVehicle = new ArrayList<>();
        listVehicle = repository.ListVehicle();
        return listVehicle;
    }

    public long calculateParkingCost(Vehicle parVehicle, LocalDateTime input, LocalDateTime output) {

        if (parVehicle == null) {
            return -1;
        }
        //El parqueadero devuelve un instancia de la jerarquia 
        IParkingCost varTarifa = ParkingCostFactory.getInstance().getParkingCost(parVehicle.getType());
        long varResultado = varTarifa.calculateCost(parVehicle, input, output);
        return varResultado;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 *
 * @author Beca98
 */
public interface IVehicleRepository {

    boolean saveVehicle(Vehicle parVehicle);

    List<Vehicle> ListVehicle();

}

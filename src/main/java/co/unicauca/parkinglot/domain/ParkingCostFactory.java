/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Beca98
 */
public class ParkingCostFactory {

    private static ParkingCostFactory instance;
    private Map<TypeEnum, IParkingCost> dictionary;

    /**
     * si se requiere otro tipo de vehiculo , se abre un registro en el
     * diccionario para no violar el principio
     */
    private ParkingCostFactory() {

        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());

    }

    /**
     * Funcion encargada de retornar la instancia de la clase...
     *
     * @return Retorna una instancia unica del vehiculo.
     */
    public static ParkingCostFactory getInstance() {

        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;

    }

    /**
     *
     * Funcion que de determina para un respectivo vehiculo la clase encargada
     * de calcular el costo del parqueadero...
     *
     * @param parTypeVeh parametro de tipo Vehiculo
     * @return Retorna una instancia con algun tipo de vehiculo.
     */
    public IParkingCost getParkingCost(TypeEnum parTypeVeh) {

        IParkingCost varResult = null;
        if (dictionary.containsKey(parTypeVeh)) {
            varResult = dictionary.get(parTypeVeh);
        }
        return varResult;

    }

}

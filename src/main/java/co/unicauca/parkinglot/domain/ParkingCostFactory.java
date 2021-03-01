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

    private static ParkingCostFactory VarInstance;
    private Map<TypeEnum, IParkingCost> TimeCostDictionary;

    private ParkingCostFactory() {

        TimeCostDictionary = new EnumMap<>(TypeEnum.class);
        TimeCostDictionary.put(TypeEnum.CAR, new CarParkingCost());
        TimeCostDictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        TimeCostDictionary.put(TypeEnum.TRUCK, new TruckParkingCost());

    }

    /**
     * Funcion que se encarga de retornar la instancia de la clase
     *
     * @return Retorna una instancia unica del vehiculo.
     */
    public static ParkingCostFactory getInstance() {

        if (VarInstance == null) {
            VarInstance = new ParkingCostFactory();
        }
        return VarInstance;

    }

    /**
     *
     * Funcion que se encarga de determinar para un vehiculo la clase que se
     * encargara de calcular el costo del parqueadero
     *
     * @param parTypeVeh parametro de tipo Vehiculo
     * @return Retorna una instancia con algun tipo de vehiculo.
     */
    public IParkingCost ParkingCostFactory(TypeEnum parTypeVeh) {

        IParkingCost varResultado = null;
        if (TimeCostDictionary.containsKey(parTypeVeh)) {
            varResultado = TimeCostDictionary.get(parTypeVeh);
        }
        return varResultado;

    }

}

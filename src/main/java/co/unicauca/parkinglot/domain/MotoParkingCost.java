/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Está clase tiene toda la lógica que se encarga de calcular el valor a pagar
 * por motocicleta dependiendo del tiempo que uso el servicio y la tarifa
 * vigente...
 *
 * @author Beca98
 */
public class MotoParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        final long flaRate = 1000; //tarifaFija 
        final long hourlyRate = 500; //tarifaPorHora
        double fraction;

        long time = Duration.between(input, output).toMinutes();

        /*
        * Si el tiempo es menor o igual a una hora se pagará la tarifa fija 
        */
        if (time <= 60) {
            return flaRate;
        } else {
            /*
            * Después de la primera hora, pagará una tarifa de $500 la hora 
            * o su fracción(regla de tres simple). 
            */
            fraction = flaRate + (((time - 60) * hourlyRate) / 60);
            long total = (long)Math.ceil( fraction/100 )*100;
            return total;
        }
    }

}

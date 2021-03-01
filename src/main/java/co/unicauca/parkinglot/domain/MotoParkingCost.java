/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Está clase tiene toda la lógica que se encarga de calcular el valor a pagar por motocicleta dependiendo 
 * del tiempo que uso el servicio y la tarifa vigente...
 * @author Beca98
 */
public class MotoParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        final long flaRate = 1000; //tarifaFija 
        final long hourlyRate = 500; //tarifaPorHora
        long fraction;

        long time = Duration.between(input, input).toMinutes();

        if (time < 1) {
            return 0;
        } else {
            if (time < 61) {
                return flaRate;
            } else {
                fraction = flaRate + (((time - 60) * hourlyRate) / 60);
                long total = Math.round(fraction / 100) * 100;
                return total;
            }
        }

    }

}

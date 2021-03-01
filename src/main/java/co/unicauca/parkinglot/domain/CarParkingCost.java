/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Beca98
 */
public class CarParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        final long flaRate = 2000; //tarifaFija 
        final long hourlyRate = 1000; //tarifaPorHora
        long fraction;

        long time = Duration.between(input, input).toMinutes();

        if (time < 1) {
            return 0;
        } else {
            if (time < 61) {
                return flaRate;
            } else {
                fraction = ((time - 60) * hourlyRate) / 60;
                long total = hourlyRate + fraction;
                long aprox = Math.round(total / 100) * 100;
                return aprox;
            }
        }

    }

}

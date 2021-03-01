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
public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        long flaRate = 15000; //tarifa fija 
        long halfDayRate = 10000; //tarifa de medio dia 
        long fraction;
        long hours;

        long time = Duration.between(input, input).toMinutes();

        hours = time / 60;

        if (time < 1) {
            System.out.println("Tiempo negativo no es permitido");
            return 0;
        } else {
            if (winDraw((int) (Math.random() * 1000 + 1))) {
                System.out.println("FELICIDADES! Ha ganado el sorteo no debe pagar nada");
                return 0;
            } else {
                if (hours <= 12) {
                    return halfDayRate;
                } else if (hours > 12 && hours <= 24) {
                    return flaRate;
                } else {

                    fraction = ((hours - 24) * flaRate) / 24;
                    long total = flaRate + fraction;
                    long redondeo = Math.round(total / 100) * 100;
                    return redondeo;
                }
            }
        }

    }

    private boolean winDraw(int parNumero) {
        int varNumero = (int) (Math.random() * 1000 + 1);
        return parNumero == varNumero;
    }

}

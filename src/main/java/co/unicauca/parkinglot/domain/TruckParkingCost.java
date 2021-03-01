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
 * por camión dependiendo del tiempo que uso el servicio y la tarifa vigente...
 *
 * @author Beca98
 */
public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        long flaRate = 15000; //tarifa fija 
        long halfDayRate = 10000; //tarifa de medio dia 
        double fraction;
        long hours;

        long time = Duration.between(input, output).toMinutes();

        hours = time / 60;

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
                double total = flaRate + fraction;
                long round = Math.round(total / 100) * 100;
                return round;
            }
        }

    }

    private boolean winDraw(int parNumero) {
        int varNumero = (int) (Math.random() * 1000 + 1);
        return parNumero == varNumero;
    }

}

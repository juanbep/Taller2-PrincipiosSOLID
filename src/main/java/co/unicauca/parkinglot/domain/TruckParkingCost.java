/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Está clase tiene toda la lógica que se encarga de calcular el valor a pagar
 * por camión dependiendo del tiempo que uso el servicio y la tarifa vigente...
 *
 * @author Beca98
 */
public class TruckParkingCost implements IParkingCost {

    /**
     * Método que calcula la tarifa a pagar para un vehiculo de tipo camion
     *
     * @param veh parametro de tipo vehiculo
     * @param input parametro con la hora de entrada del vehiculo
     * @param output parametro con la hora de salida del vehiculo
     * @return la tarifa a pagar por el vehiculo tipo camión
     */
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        long flaRate = 15000; //tarifa fija 
        long halfDayRate = 10000; //tarifa de medio dia 
        double fraction, hours;
        Utilities sorteo = new Utilities();
        long time = Duration.between(input, output).toMinutes();

        //Envia un número random y si coincide con otro numero random el camionero gana el sorteo 
        if (sorteo.winDraw((int) (Math.random() * 1000 + 1))) {
            System.out.println("FELICIDADES! Ha ganado el sorteo no debe pagar nada");
            return 0;
        } else if (time <= 720) {

            //Si el camión está menor o igual a 12 horas se le cobra un valor de $10.000 
            // que es la tarifa de medio dia... 
            return halfDayRate;
        } else if (time > 720 & time <= 1440) {

            //SI el camión está entre 12 y 24 horas paga $15.000
            //que es la tarifa fija...
            return flaRate;
        } else {

            //En adelante de las 24 horas, pagará $15.000 por cada día y por las horas restantes 
            //se le cobra la fracción de tiempo respecto a los $15.000 (regla de tres simple)...
            hours = (double) time / 60;
            fraction = ((hours - 24) * flaRate) / 24;
            double total = flaRate + fraction;
            long aprox = (long) Math.ceil(total / 100) * 100;
            return aprox;
        }

    }

}

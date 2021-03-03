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
 * por carro dependiendo del tiempo que uso el servicio y la tarifa vigente...
 *
 * @author Beca98
 */
public class CarParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        final long flaRate = 2000; //tarifaFija 
        final long hourlyRate = 1000; //tarifaPorHora
        double fraction;

        long time = Duration.between(input, output).toMinutes();

        if (time <= 60) {
            /*
            * Si el tiempo es menor o igual a una hora retorna la tarifa fija 
            */
            return flaRate;
        } else {
            /*
            * Si el tiempo es mayor a una hora se pagará una tarifa de 1.000 la hora  
            * o   su   fracción   (regla   de   tres   simple).  
            */
            fraction = ((time - 60) * hourlyRate) / 60;
            double total = flaRate + fraction;
            long aprox = (long)Math.ceil(total / 100) * 100;
            return aprox;
        }

    }

}

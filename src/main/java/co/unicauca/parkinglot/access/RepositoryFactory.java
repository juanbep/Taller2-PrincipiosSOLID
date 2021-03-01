/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

/**
 *
 * @author Beca98
 */
public class RepositoryFactory {

    private static RepositoryFactory instance;

    private RepositoryFactory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }

    public IVehicleRepository getRepository(String type) {

        IVehicleRepository result = null;

        switch (type) {
            case "default" -> result = new VehicleRepository();
        }

        return result;

    }

}

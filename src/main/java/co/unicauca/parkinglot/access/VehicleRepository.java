/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beca98
 */
public class VehicleRepository implements IVehicleRepository {

    private Connection conn;

    /**
     * Constructor por defecto de la clase VehicleRepository.
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Funcion para crear la tabla Vehicle y la base de datos (en memoria).
     */
    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS Vehiculo (\n"
                + "	Placa text PRIMARY KEY,\n"
                + ");";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion que conecta la aplicacion con la base de datos.
     */
    public void connect() {
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion que desconecta la aplicacion de la base de datos.
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean saveVehicle(Vehicle parVehicle) {
        try {
            if (parVehicle == null || parVehicle.getPlate().isEmpty()) {
                return false;
            }
            String sql = "INSERT INTO Vehiculo ( Placa ) " + "VALUES ( ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, parVehicle.getPlate());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehicle> ListVehicle() {
        List<Vehicle> listVehicle = new ArrayList<>();
        try {
            String sql = "SELECT Placa FROM Vehiculo";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle varVehicle = new Vehicle();
                varVehicle.setPlate(rs.getString("Placa"));

                listVehicle.add(varVehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listVehicle;
    }

}

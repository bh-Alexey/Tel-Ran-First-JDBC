package com.telran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainDAO {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://bh-alexey:5432/postgres", "bh-alexey", "Vrndavan");

        CarDAO carDAO = new CarDAO(connection);

        List<Car> cars = carDAO.getAllCars();

//        Car car = new Car(10, "BMW", "Germany");
//        carDAO.insertCar(car);

//        carDAO.deleteCar(10);

//        carDAO.updateCar();
    }
}

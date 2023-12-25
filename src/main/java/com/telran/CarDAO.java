package com.telran;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private Connection connection;

    public CarDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Car> getAllCars(int pageSize, int pageNum) throws SQLException {
        List<Car> list = new ArrayList<>();

        Statement statement = connection.createStatement();
        int paging = 0;
        if (pageNum > 1) {
            paging = pageSize * pageNum - pageSize;
        }
        ResultSet resultSet = statement.executeQuery("SELECT * FROM car ORDER BY car.id LIMIT " + pageSize + "  OFFSET " + paging);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String country = resultSet.getString("country");
            Car car = new Car(id, name, country);
            list.add(car);
        }

        return list;
    }

    public void insertCar(Car car) throws SQLException {
        Statement statement = connection.createStatement();
        int id = car.getId();
        String name = car.getName();
        String country = car.getCountry();
        String query = "INSERT INTO car VALUES (" + id + ", '" + name + "', '" + country + "');";
        statement.execute(query);
    }

    public void deleteCar(int carID) throws SQLException {

        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM car WHERE id =" + carID);
    }

    public void updateCar() throws SQLException {

        Statement statement = connection.createStatement();
        statement.execute("UPDATE car SET id = id + 100" );
    }
}

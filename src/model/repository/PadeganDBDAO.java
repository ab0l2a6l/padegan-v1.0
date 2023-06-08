package model.repository;

import model.entity.Padegan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PadeganDBDAO implements PadeganDBDAORead, PadeganDBDAOWrite {

    private Connection connection;
    private Statement statement;
    private final String url = "jdbc:mysql://localhost:3306/firstdb";
    private final String username = "root";
    private final String password = "Am311865186";
    private String query;


    public PadeganDBDAO() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("connected");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(Padegan padegan) throws Exception {

        query = "insert into padegan set values padegan_id = " + padegan.getId() +
                ", padegan_full_name = " + padegan.getFullName() +
                ", padegan_saat_vorood= " + padegan.getEntryTime() +
                ",padegan_saat_khorooj=" + padegan.getDepartureTime() +
                ", padegan_date=  " + padegan.getDate();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
        System.out.println("disconnected");
    }

}

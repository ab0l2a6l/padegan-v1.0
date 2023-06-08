package model.repository;

import model.entity.Padegan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
                ", padegan_full_name = \"" + padegan.getFullName() + "\"" +
                ", padegan_saat_vorood= \"" + padegan.getEntryTime() + "\"" +
                ",padegan_saat_khorooj=\"" + padegan.getDepartureTime() + "\"" +
                ", padegan_date=  " + padegan.getDate();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public Padegan readData(long id, String date) throws Exception {
        query = "select * from padegan where padegan_id = " + id + ", padegan_date = \"" + date + "\"";
        ResultSet set = statement.executeQuery(query);
        if (set.next()) {
            Padegan padegan = new Padegan();
            padegan.setId(set.getInt("padegan_id"));
            padegan.setFullName(set.getString("padegan_full_name"));
            padegan.setEntryTime(set.getString("padegan_saat_vorood"));
            padegan.setDepartureTime(set.getString("padegan_saat_khorooj"));
            padegan.setDate(set.getString("padegan_date"));
            return padegan;
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
        System.out.println("disconnected");
    }
}

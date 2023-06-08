package model.repository;

import model.entity.Padegan;

import java.sql.Statement;

public class PadeganDBDAO implements PadeganDBDAORead, PadeganDBDAOWrite {

    Statement statement;
    String query;

    @Override
    public void save(Padegan padegan) {
        try {
            query = "insert into padegan set values padegan_id = " + padegan.getId() +
                    ", padegan_full_name = " + padegan.getFullName() +
                    ", padegan_saat_vorood= " + padegan.getEntryTime() +
                    ",padegan_saat_khorooj=" + padegan.getDepartureTime() +
                    ", padegan_date=  " + padegan.getDate();
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

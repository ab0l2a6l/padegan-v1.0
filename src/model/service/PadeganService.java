package model.service;

import model.entity.Padegan;
import model.repository.PadeganDBDAO;
import model.repository.PadeganDBDAOWrite;

public class PadeganService implements PadeganServiceRead , PadeganServiceWrite{

    PadeganDBDAOWrite write;
    @Override
    public void save(Padegan padegan) {
        try {
            write =new PadeganDBDAO();
            write.save(padegan);
            write.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

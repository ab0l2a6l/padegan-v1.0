package model.repository;

import model.entity.Padegan;

public interface PadeganDBDAORead {

    Padegan readData(long id , String date)throws Exception ;

    void close() throws Exception;
}

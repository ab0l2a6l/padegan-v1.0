package model.repository;

import model.entity.Padegan;

public interface PadeganDBDAOWrite {
    void save(Padegan padegan) throws Exception;

    void close() throws Exception;
}

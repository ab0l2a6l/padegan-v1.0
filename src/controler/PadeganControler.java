package controler;

import model.entity.Padegan;
import model.service.PadeganService;
import model.service.PadeganServiceRead;
import model.service.PadeganServiceWrite;

public class PadeganControler {
    PadeganServiceWrite write = new PadeganService();
    PadeganServiceRead read = new PadeganService();

    public void save(Padegan padegan) {
        write.save(padegan);
    }

    public Padegan readDate(long id, String date) {
        return read.readData(id, date);
    }

}

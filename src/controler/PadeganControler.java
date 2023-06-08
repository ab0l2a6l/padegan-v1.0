package controler;

import model.entity.Padegan;
import model.service.PadeganService;
import model.service.PadeganServiceWrite;

public class PadeganControler {
    PadeganServiceWrite write = new PadeganService();

    public void save(Padegan padegan) {
        write.save(padegan);
    }

}

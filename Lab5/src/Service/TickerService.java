package Service;

import Entity.Ticker;
import IGeneric.IGeneral;

import java.util.List;
import java.util.Optional;

public class TickerService {

    List<Ticker> tickers;
    public TickerService(List<Ticker> tickers) {
        this.tickers = tickers;
    }

    public void createTicker(String symbol, String exchange, String companyName) {
        Ticker newTicker = new Ticker(tickers.size() + 1 ,symbol, exchange, companyName);
        tickers.add(newTicker);
    }


    public Ticker getById(int id) {
        Optional<Ticker> ticker = tickers.stream()
                .filter(tick -> tick.getId() == id)
                .findFirst();
        return ticker.isPresent() ? ticker.get() : null;
    }
}

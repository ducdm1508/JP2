package Controller;

import Entity.Ticker;
import Service.TickerService;

import java.util.Optional;

public class TickerController {

    private TickerService tickerService;
    public TickerController(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    public void creatTicker(String symbol, String exchange, String companyName ) {
        tickerService.createTicker(symbol, exchange, companyName);
    }

    public void updateTicker(int id, String newExchange) {
        Ticker tiker = tickerService.getById(id);
        if (tiker != null) {
            tiker.setExchange(newExchange);
        }else {
            System.out.println("Ticker not found");
        }
    }
}

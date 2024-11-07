import Controller.TickerController;
import Entity.Pricing;
import Entity.Ticker;
import Service.TickerService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Pricing> pricings = new ArrayList<>();
        List<Ticker> tickers = new ArrayList<>();

        TickerService tickerService = new TickerService(tickers);
        TickerController tickerController = new TickerController(tickerService);

        tickerController.creatTicker("APP", "AOWOR", "Apple");
        

    }
}
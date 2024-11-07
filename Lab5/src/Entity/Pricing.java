package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pricing {
    private int id;
    private Ticker ticker;
    private LocalDateTime dateTime;
    private double openPrice;
    private double closePrice;
    private double currentPrice;

    public Pricing() {;}
    public Pricing(int id, Ticker ticker, LocalDateTime dateTime, double openPrice, double closePrice, double currentPrice) {
        this.id = id;
        this.ticker = ticker;
        this.dateTime = dateTime;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.currentPrice = currentPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Pricing{" +
                "id=" + id +
                ", ticker=" + ticker.getSymbol() + " (" + ticker.getCompanyName() + ")" +
                ", dateTime=" + dateTime +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", currentPrice=" + currentPrice +
                '}';
    }
}

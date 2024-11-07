package Service;

import Entity.Pricing;
import Entity.Ticker;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PricingService {
    List<Pricing> pricings;

    public PricingService(List<Pricing> pricings) {
        this.pricings = pricings;
    }
    public void addPriceForTicker(Ticker ticker, LocalDateTime dateTime, double openPrice, double closePrice, double currentPrice) {
        Pricing newPricing = new Pricing(
                pricings.size() + 1,
                ticker,
                dateTime,
                openPrice,
                closePrice,
                currentPrice
        );
        pricings.add(newPricing);
        System.out.println("Đã thêm giá cho ticker " + ticker.getSymbol() + " vào " + dateTime);
    }
    public Map<String, Double> getRealTimePrice(String symbol) {
        return pricings.stream()
                .filter(pricing -> pricing.getTicker().getSymbol().equalsIgnoreCase(symbol))
                .collect(Collectors.toMap(
                        pricing -> pricing.getTicker().getSymbol(),
                        Pricing::getCurrentPrice
                ));
    }
}

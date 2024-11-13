package Service;

import Entity.Behavior;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BehaviorService {
    private List<Behavior> behaviors;

    public BehaviorService(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }

    public void calculateBehaviorAndWriteToFile(String filePath) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");


        Map<String, Map<Integer, List<Behavior>>> behaviorMap = behaviors.stream()
                .collect(Collectors.groupingBy(
                        behavior -> behavior.getDatetime().format(formatter),
                        Collectors.groupingBy(Behavior::getProductId)
                ));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            behaviorMap.forEach((monthYear, productBehaviors) -> {

                productBehaviors.forEach((productId, behaviorsInMonth) -> {

                    int totalClick = behaviorsInMonth.stream().mapToInt(Behavior::getClick).sum();
                    int totalAddToCart = behaviorsInMonth.stream().mapToInt(Behavior::getAddToCard).sum();
                    int totalCheckOut = behaviorsInMonth.stream().mapToInt(Behavior::getCheckOut).sum();


                    double clickPercent = totalClick == 0 ? 0 : (double) totalClick / totalClick * 100;
                    double addToCartPercent = totalAddToCart == 0 ? 0 : (double) totalAddToCart / totalAddToCart * 100;
                    double checkOutPercent = totalCheckOut == 0 ? 0 : (double) totalCheckOut / totalCheckOut * 100;


                    String result = String.format("%d; %.2f; %.2f; %.2f; %s",
                            productId, clickPercent, addToCartPercent, checkOutPercent, monthYear);
                    try {
                        writer.write(result);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });
        }
    }
}

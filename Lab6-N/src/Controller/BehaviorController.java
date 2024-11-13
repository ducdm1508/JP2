package Controller;

import Service.BehaviorService;

import java.io.IOException;

public class BehaviorController {
    BehaviorService behaviorService;
    public BehaviorController(BehaviorService behaviorService) {
        this.behaviorService = behaviorService;
    }

    public void calculateBehaviorAndWriteToFile(String filePath){
        try {
            behaviorService.calculateBehaviorAndWriteToFile(filePath);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

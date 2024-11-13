import Controller.BehaviorController;
import Controller.FileController;
import Entity.Behavior;
import Service.BehaviorService;
import Service.FileService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Behavior> behaviors = new ArrayList<Behavior>();

        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath.replace("/","\\") + "/data/behavior.in.txt";
        String fileOutPath = sysPath.replace("/","\\") + "/data/behaviorpersent.out.txt";

        FileService fileService = new FileService(behaviors);
        FileController fileController = new FileController(fileService);

        BehaviorService behaviorService = new BehaviorService(behaviors);
        BehaviorController behaviorController = new BehaviorController(behaviorService);

        List<Behavior> readFile = fileService.readFile(fileInPath);
        readFile.forEach(behavior -> System.out.println(behavior.toString(";")));

        behaviorController.calculateBehaviorAndWriteToFile(fileOutPath);
    }
}
import Controller.FileController;
import Controller.StatisticViewController;
import Entity.CRStatistics;
import Entity.PCStatistics;
import Entity.StatisticsView;
import Service.FileService;
import Service.StatisticsViewService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fileInPathStatistics = System.getProperty("user.dir").replace("/","\\") + "/data/statistics.view.txt";
        String fileOutPathStatistics = System.getProperty("user.dir").replace("/","\\") + "/data/percentstatistic.out.txt";

        FileService fileService = new FileService();
        FileController fileController = new FileController(fileService);

        List<StatisticsView> statisticsViews= fileController.readFileStasistics(fileInPathStatistics);

        StatisticsViewService statisticsViewService = new StatisticsViewService(statisticsViews);
        StatisticViewController statisticViewController = new StatisticViewController(statisticsViewService);

        List<CRStatistics> statistics = statisticViewController.getTotalStatistics();

        statistics.forEach(System.out::println);

        List<PCStatistics> pecentStatistics = statisticsViewService.getPecentStatistics();
        pecentStatistics.forEach(System.out::println);

        fileController.writeFileStasistics(pecentStatistics, fileOutPathStatistics);
    }
}
package Controller;

import Entity.CRStatistics;
import Service.StatisticsViewService;

import java.util.List;

public class StatisticViewController {
    private StatisticsViewService statisticsViewService;
    public StatisticViewController(StatisticsViewService statisticsViewService) {
        this.statisticsViewService = statisticsViewService;
    }

    public List<CRStatistics> getTotalStatistics(){
        return statisticsViewService.getTotalStatistics();
    }
}

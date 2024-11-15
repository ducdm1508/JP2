package Service;

import Entity.CRStatistics;
import Entity.PCStatistics;
import Entity.StatisticsView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsViewService {
    List<StatisticsView> statisticsViewList;

    public StatisticsViewService(List<StatisticsView> statisticsViewList) {
        this.statisticsViewList = statisticsViewList;
    }

    public List<CRStatistics> getTotalStatistics() {

        Map<CRStatistics, CRStatistics> dataCRS = statisticsViewList.stream()
                .collect(Collectors.groupingBy(
                        cr -> new CRStatistics(cr.getId(),cr.getMonthOfDate(), cr.getYearOfDate()),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                listCr ->{
                                    CRStatistics crStatistics = new CRStatistics();
                                    StatisticsView firtStatistics = listCr.getFirst();
                                    int toalView = listCr.stream().mapToInt(StatisticsView::getView).sum();
                                    crStatistics.setId(firtStatistics.getId());
                                    crStatistics.setMonth(firtStatistics.getMonthOfDate());
                                    crStatistics.setYear(firtStatistics.getYearOfDate());
                                    crStatistics.setTotalView(toalView);
                                    crStatistics.setTotalAddToCard(listCr.stream().mapToInt(StatisticsView::getAddToCart).sum());
                                    crStatistics.setTotalCheckOut(listCr.stream().mapToInt(StatisticsView::getCheckOut).sum());
                                    return crStatistics;
                                }
                        )
                ));
        return dataCRS.values().stream().collect(Collectors.toList());
    }
    public List<PCStatistics> getPecentStatistics() {
        List<CRStatistics> totalStatistics = getTotalStatistics();

        Map<CRStatistics, CRStatistics> totalStatisticsMap = totalStatistics.stream()
                .collect(Collectors.toMap(
                        cr -> new CRStatistics(cr.getId(), cr.getMonth(), cr.getYear()),
                        cr -> cr
                ));


        List<PCStatistics> pcStatisticsList = statisticsViewList.stream()
                .map(stat -> {

                    CRStatistics key = new CRStatistics(stat.getId(), stat.getMonthOfDate(), stat.getYearOfDate());
                    CRStatistics totalStat = totalStatisticsMap.getOrDefault(key, new CRStatistics());

                    double percentView = (totalStat.getTotalView() == 0) ? 0 :
                            (stat.getView() * 100.0) / totalStat.getTotalView();
                    double percentAddToCart = (totalStat.getTotalAddToCard() == 0) ? 0 :
                            (stat.getAddToCart() * 100.0) / totalStat.getTotalAddToCard();
                    double percentCheckOut = (totalStat.getTotalCheckOut() == 0) ? 0 :
                            (stat.getCheckOut() * 100.0) / totalStat.getTotalCheckOut();


                    return new PCStatistics(
                            stat.getId(),
                            percentView,
                            percentAddToCart,
                            percentCheckOut,
                            stat.getCreateAtDate()
                    );
                })
                .collect(Collectors.toList());

        return pcStatisticsList;
}
}

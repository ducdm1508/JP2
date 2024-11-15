package Service;

import Entity.PCStatistics;
import Entity.StatisticsView;
import General.IFileService;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileService implements IFileService<StatisticsView> {

    public FileService(){;}

    @Override
    public List<StatisticsView> readFileStasistics(String fileInPath) {
        List<StatisticsView> statisticsViews = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath));
            String line;
            while((line=bufferedReader.readLine())!=null){
                StatisticsView statisticsView = new StatisticsView();
                if(!line.isEmpty()) {
                    String[] arrData = line.split(";");
                    statisticsView.setId(Integer.parseInt(String.valueOf(arrData[0])));
                    statisticsView.setView(Integer.parseInt(arrData[1]));
                    statisticsView.setAddToCart(Integer.parseInt(arrData[2]));
                    statisticsView.setCheckOut(Integer.parseInt(arrData[3]));
                    statisticsView.setCreateAtDate(LocalDate.parse(String.valueOf(arrData[4])));
                    statisticsViews.add(statisticsView);
                }
            }
        }catch (IOException e){
            e.getCause();
        }
        return statisticsViews;
    }


    public void writeFileStasistics(List<PCStatistics> pcStatistics, String filePath) {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            pcStatistics.stream()
                    .peek(pcs -> {
                        try {
                            String line2Write = pcs.toString();
                            bufferedWriter.write(line2Write);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }catch (IOException e){
                            e.getCause();
                        }
                    }).collect(Collectors.toList());
        }catch (IOException e){
            e.getCause();
        }
    }
}

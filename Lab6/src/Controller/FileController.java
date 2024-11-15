package Controller;

import Entity.PCStatistics;
import Entity.StatisticsView;
import Service.FileService;

import java.util.List;

public class FileController {
    private FileService fileService;
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    public List<StatisticsView> readFileStasistics(String filePath){
        return fileService.readFileStasistics(filePath);
    }

    public void writeFileStasistics(List<PCStatistics>pcStatisticsList, String filePath){
        fileService.writeFileStasistics(pcStatisticsList, filePath);
    }
}

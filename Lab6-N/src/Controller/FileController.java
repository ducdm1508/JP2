package Controller;

import Entity.Behavior;
import Service.FileService;

import java.util.List;

public class FileController {
    FileService fileService;
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    public List<Behavior> readFile(String filePath){
        return fileService.readFile(filePath);
    }
    public List<Behavior> writerFile(String filePath){
        return fileService.writerFile(filePath);
    }
}

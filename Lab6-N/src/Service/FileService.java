package Service;

import Entity.Behavior;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileService {

    private List<Behavior> behaviors;
    public FileService(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }

    public List<Behavior> readFile(String filePath) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null ){
                Behavior behavior = new Behavior();
                if (!line.isEmpty()){
                    String[] data = line.split("; ");
                    behavior.setProductId(Integer.parseInt(String.valueOf(data[0])));
                    behavior.setCkick(Integer.parseInt(String.valueOf(data[1])));
                    behavior.setAddToCard(Integer.parseInt(String.valueOf(data[2])));
                    behavior.setCheckOut(Integer.parseInt(String.valueOf(data[3])));
                    behavior.setDatetime(LocalDate.parse(data[4], formatter));
                }
                behaviors.add(behavior);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return behaviors;
    }

    public List<Behavior> writerFile(String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            behaviors.stream().peek(behavior -> {
                try{
                    bw.write(behavior.toString(";"));
                    bw.newLine();
                    bw.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
        return behaviors;
    }
}

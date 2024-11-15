package General;

import java.util.List;

public interface IFileService <T>{
    List<T> readFileStasistics(String filePath);
//    void writeFileStasistics(String filePath);
}

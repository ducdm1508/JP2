package IGeneric;

import java.util.Map;
import java.util.Set;

public interface IGeneral<T> {
    Set<T> searchByName(String name);
    Map<String, Set<T>> groupByDepartmentName();
    Map<String, Long> countTotalEmployees();

}

package util;

import model.BaseEntity;

import java.util.List;

public class SortUtil {

    public static List<BaseEntity> sortByName(List<BaseEntity> list) {
        return list.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .toList();
    }
}

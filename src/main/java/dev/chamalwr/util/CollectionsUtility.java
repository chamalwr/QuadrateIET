package dev.chamalwr.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionsUtility {

    public static Map<Integer, Integer> sortHashMapByKey(Map<Integer, Integer> unsortedMap){
        return unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Long> frequency = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        return frequency.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue().intValue()))
                .collect(Collectors.joining());
    }
}
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = Arrays.stream(numbers)
                                  .boxed()
                                  .map(String::valueOf)
                                  .sorted(comparator())
                                  .collect(Collectors.toList());

        if(list.stream().allMatch(s -> s.equals("0"))) {
            return "0";
        }
        
        return String.join("", list);
    }
    
    private static Comparator<? super String> comparator() {
        return (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
    }
}
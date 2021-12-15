package wb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author 王波
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        HashMap<Character, Integer> map = new HashMap<>(licensePlate.length());
        for (char c : licensePlate.toCharArray()) {
            if (c > 'a' && c < 'z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if (c > 'A' && c < 'Z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return null;
    }
}

package wb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 王波
 */
public class TopVotedCandidate {
    HashMap<Integer, Integer> map;
    int[][] arr;
    int length = 0;

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        length = n;
        map = new HashMap<>(n);
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = persons[i];
            arr[1][i] = times[i];
        }
    }

    public int q(int t) {
        int max = 0, index = 0;
        map.clear();
        for (int i = 0; i < length && arr[1][i] <= t; i++) {
            index = i;
        }
        for (int i = index; i >= 0; i--) {
            map.put(arr[0][i], map.getOrDefault(arr[0][i], 0) + 1);
            max = Math.max(max, map.get(arr[0][i]));
        }
        for (int i = index; i >= 0; i--) {
            if (map.get(arr[0][i]) == max) {
                return arr[0][i];
            }
        }
        return 0;
    }
}